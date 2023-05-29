package jy.demo.service;

import javax.transaction.Transactional;
import jy.demo.common.HttpResponse;
import jy.demo.dto.ProfileReqDto;
import jy.demo.exception.BadRequestException;
import jy.demo.exception.DataNotFoundException;
import jy.demo.model.Profile;
import jy.demo.model.User;
import jy.demo.repository.ProfileRepository;
import jy.demo.repository.UserRepository;
import jy.demo.security.oauth2.CustomOAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UserService(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }


    @Transactional
    public User saveOrUpdate(CustomOAuth2User customOAuth2User) {
        User user = userRepository.findBySocialProviderKey(customOAuth2User.getSocialProviderKey())
            .map(savedUser -> savedUser.update(customOAuth2User))
            .orElse(customOAuth2User.toUser());

        return userRepository.save(user);
    }

    @Transactional
    public void saveProfile(Long userId, ProfileReqDto dto) {
        if (isUserhasProflie(userId)) {
            throw new BadRequestException(HttpResponse.PROFILE_EXIST);
        }

        Profile profile = dto.toEntity(userId);

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new DataNotFoundException(HttpResponse.USER_NOT_FOUND));

        user.setProflie(profile);
    }

    public Boolean isUserhasProflie(Long userId) {
        return profileRepository.existsByUserId(userId);
    }
}
