package jy.demo.service;

import jy.demo.common.HttpResponse;
import jy.demo.dto.ProfileReqDto;
import jy.demo.exception.BadRequestException;
import jy.demo.model.Profile;
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

    public Profile saveProfile(Long userId, ProfileReqDto dto) {
        if (isUserhasProflie(userId)) {
            throw new BadRequestException(HttpResponse.PROFILE_EXIST);
        }

        Profile profile = dto.toEntity(userId);
        return profileRepository.save(profile);
    }


}
