package jy.demo.controller;

import java.util.Map;
import javax.validation.Valid;
import jy.demo.common.HttpResponse;
import jy.demo.dto.ProfileReqDto;
import jy.demo.security.UserDetailsImpl;
import jy.demo.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
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

    @GetMapping("/signedUp")
    public Map<String, Boolean> isUserHasProfile(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String key = "hasProfile";
        Boolean hasProfile = profileService.isUserhasProflie(userDetails.getUserId());

        return Map.of(key, hasProfile);
    }
}