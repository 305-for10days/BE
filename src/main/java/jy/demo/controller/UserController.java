package jy.demo.controller;

import javax.validation.Valid;
import jy.demo.common.HttpResponse;
import jy.demo.dto.ProfileReqDto;
import jy.demo.security.UserDetailsImpl;
import jy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/profile")
    public ResponseEntity<String> saveProfile(@AuthenticationPrincipal UserDetailsImpl userDetails,
        @Valid @RequestBody ProfileReqDto profileReqDto) {

        userService.saveProfile(userDetails.getUserId(), profileReqDto);

        return HttpResponse.OK.getResponseEntity();
    }
}

