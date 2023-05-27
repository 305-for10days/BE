package jy.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import jy.demo.common.HttpResponse;
import jy.demo.dto.EmojiDto;
import jy.demo.dto.RoutineDto;
import jy.demo.dto.RoutineItemDto;
import jy.demo.exception.DataNotFoundException;
import jy.demo.model.DefaultRoutine;
import jy.demo.model.Exercise;
import jy.demo.model.ExerciseGoal;
import jy.demo.model.RoutineItem;
import jy.demo.model.User;
import jy.demo.model.UserRoutine;
import jy.demo.repository.DefaultRoutineRepository;
import jy.demo.repository.ExerciseGoalRepository;
import jy.demo.repository.ExerciseRepository;
import jy.demo.repository.RoutineItemRepository;
import jy.demo.repository.UserRoutineRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoutineService {

    private final UserRoutineRepository userRoutineRepository;
    private final DefaultRoutineRepository defaultRoutineRepository;
    private final ExerciseGoalRepository exerciseGoalRepository;
    private final RoutineItemRepository routineItemRepository;
    private final ExerciseRepository exerciseRepository;


    public RoutineService(UserRoutineRepository userRoutineRepository,
        DefaultRoutineRepository defaultRoutineRepository,
        ExerciseGoalRepository exerciseGoalRepository, RoutineItemRepository routineItemRepository,
        ExerciseRepository exerciseRepository) {
        this.userRoutineRepository = userRoutineRepository;
        this.defaultRoutineRepository = defaultRoutineRepository;
        this.exerciseGoalRepository = exerciseGoalRepository;
        this.routineItemRepository = routineItemRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Transactional(readOnly = true)
    public List<DefaultRoutine> getDefaultRoutines() {
        return defaultRoutineRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<UserRoutine> getLatestUserRoutine(Long userId, List<Long> exerciseGoalIds) {
        return userRoutineRepository.findLatestUserRoutines(userId, exerciseGoalIds);
    }


    @Transactional
    public Long saveUserRoutine(Long userId, RoutineDto dto) {
        ExerciseGoal exerciseGoal = exerciseGoalRepository.findByGoal(dto.getGoal())
            .orElseThrow(() -> new DataNotFoundException(HttpResponse.EXERCISE_GOAL_NOT_FOUND));

        UserRoutine userRoutine = UserRoutine.builder()
            .user(new User(userId))
            .exerciseGoal(exerciseGoal)
            .calorie(calculateCalorie(dto))
            .build();

        List<RoutineItem> routineItems = generateRoutineItem(dto.getDetails());
        routineItems.forEach(userRoutine::addRoutineItem);

        return userRoutineRepository.save(userRoutine).getId();
    }

    private List<RoutineItem> generateRoutineItem(List<RoutineItemDto> itemDtos) {

        return itemDtos.stream()
            .map(itemDto -> {
                Exercise exercise = exerciseRepository.findById(itemDto.getWorkoutId())
                    .orElseThrow(() -> new DataNotFoundException(HttpResponse.EXERCISE_NOT_FOUND));

                return RoutineItem.builder()
                    .exercise(exercise)
                    .goalCalorie(itemDto.getCalorie())
                    .setCount(itemDto.getSet())
                    .build();
            })
            .collect(Collectors.toList());
    }

    private int calculateCalorie(RoutineDto dto) {
        return dto.getDetails().stream()
            .map(item -> item.getCompletedSet() * item.getCalorie())
            .mapToInt(Integer::intValue)
            .sum();
    }

    @Transactional
    public void saveEmoji(Long userId, EmojiDto dto) {
        UserRoutine userRoutine = userRoutineRepository.findByIdAndUser(dto.getRoutineId(), new User(userId))
            .orElseThrow(() -> new DataNotFoundException(HttpResponse.USER_ROUTINE_NOT_FOUND));

        userRoutine.setEmoji(dto.getEmojiId());
    }

    public Page<UserRoutine> getUserRoutineRecord(Long userId, int page) {
        int size = 10;
        String sort = "createdAt";

        PageRequest pageable = PageRequest.of(page, size, Sort.by(sort).descending());

        return userRoutineRepository.findAllByUser(new User(userId), pageable);

    }
}