package jy.demo.service;

import javax.transaction.Transactional;
import jy.demo.model.User;
import jy.demo.repository.UserRepository;
import jy.demo.security.oauth2.CustomOAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional
    public User saveOrUpdate(CustomOAuth2User customOAuth2User) {
        User user = userRepository.findBySocialProviderKey(customOAuth2User.getSocialProviderKey())
            .map(savedUser -> savedUser.update(customOAuth2User))
            .orElse(customOAuth2User.toUser());

        return userRepository.save(user);
    }

}
