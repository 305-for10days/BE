package jy.demo.service;

import jy.demo.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;


    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Boolean isUserhasProflie(Long userId) {
        return profileRepository.existsByUserId(userId);
    }

}
