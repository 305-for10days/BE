package jy.demo.service;

import java.util.List;
import javax.transaction.Transactional;
import jy.demo.common.HttpResponse;
import jy.demo.exception.DataNotFoundException;
import jy.demo.model.User;
import jy.demo.model.UserRoutine;
import jy.demo.repository.UserRepository;
import jy.demo.repository.UserRoutineRepository;
import jy.demo.security.oauth2.CustomOAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoutineRepository userRoutineRepository;

    public UserService(UserRepository userRepository, UserRoutineRepository userRoutineRepository) {
        this.userRepository = userRepository;
        this.userRoutineRepository = userRoutineRepository;
    }


    @Transactional
    public User saveOrUpdate(CustomOAuth2User customOAuth2User) {
        User user = userRepository.findBySocialProviderKey(customOAuth2User.getSocialProviderKey())
            .map(savedUser -> savedUser.update(customOAuth2User))
            .orElse(customOAuth2User.toUser());

        return userRepository.save(user);
    }

    public List<UserRoutine> getUserRoutines(Long userId) {
        // TODO: user의 routine 중 관련된 정보 조인해서 한번해 가져오도록 구현
        return userRepository.findById(userId)
            .map(User::getRoutines)
            .orElseThrow(() -> new DataNotFoundException(HttpResponse.USER_NOT_FOUND));
    }

    public List<UserRoutine> getLatestUserRoutine(Long userId, List<Long> exerciseGoalIds) {
        return userRoutineRepository.findLatestUserRoutines(userId, exerciseGoalIds);
    }
}
