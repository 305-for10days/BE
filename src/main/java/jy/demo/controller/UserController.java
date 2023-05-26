package jy.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import jy.demo.dto.RoutineDto;
import jy.demo.security.UserDetailsImpl;
import jy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/user/routine")
    public List<RoutineDto> getUserExerciseGoals(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.getLatestUserRoutine(userDetails.getUserId(), List.of(1L, 2L, 3L))
            .stream().map(RoutineDto::new).collect(Collectors.toList());
    }
}

