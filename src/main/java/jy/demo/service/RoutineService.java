package jy.demo.service;

import java.util.List;
import jy.demo.model.DefaultRoutine;
import jy.demo.model.UserRoutine;
import jy.demo.repository.DefaultRoutineRepository;
import jy.demo.repository.UserRoutineRepository;
import org.springframework.stereotype.Service;

@Service
public class RoutineService {

    private final UserRoutineRepository userRoutineRepository;
    private final DefaultRoutineRepository defaultRoutineRepository;


    public RoutineService(UserRoutineRepository userRoutineRepository,
        DefaultRoutineRepository defaultRoutineRepository) {
        this.userRoutineRepository = userRoutineRepository;
        this.defaultRoutineRepository = defaultRoutineRepository;
    }

    public List<DefaultRoutine> getDefaultRoutines() {
        return defaultRoutineRepository.findAll();
    }

    public List<UserRoutine> getLatestUserRoutine(Long userId, List<Long> exerciseGoalIds) {
        return userRoutineRepository.findLatestUserRoutines(userId, exerciseGoalIds);
    }
}
