package jy.demo.service;

import jy.demo.dto.ProfileReqDto;
import jy.demo.model.Profile;
import jy.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;


    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    public Profile saveProfile(Long userId, ProfileReqDto dto) {
        Profile profile = dto.toEntity(userId);
        return profileRepository.save(profile);
    }


}
