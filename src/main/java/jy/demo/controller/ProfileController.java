package jy.demo.controller;

import javax.validation.Valid;
import jy.demo.common.HttpResponse;
import jy.demo.dto.ProfileReqDto;
import jy.demo.security.UserDetailsImpl;
import jy.demo.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @PostMapping("/profile")
    public ResponseEntity<String> saveProfile(@AuthenticationPrincipal UserDetailsImpl userDetails,
        @Valid @RequestBody ProfileReqDto profileReqDto) {

        profileService.saveProfile(userDetails.getUserId(), profileReqDto);

        return HttpResponse.OK.getResponseEntity();
    }
}