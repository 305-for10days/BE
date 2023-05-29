package jy.demo.controller;

import java.util.Map;
import jy.demo.security.UserDetailsImpl;
import jy.demo.service.ProfileService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @GetMapping("/signedUp")
    public Map<String, Boolean> isUserHasProfile(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String key = "hasProfile";
        Boolean hasProfile = profileService.isUserhasProflie(userDetails.getUserId());

        return Map.of(key, hasProfile);
    }
}