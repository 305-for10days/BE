package jy.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import jy.demo.dto.RoutineDto;
import jy.demo.security.UserDetailsImpl;
import jy.demo.service.RoutineService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoutineController {

    private final RoutineService routineService;

    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    @GetMapping("/routine")
    public List<RoutineDto> getExerciseGoals() {
        return routineService.getDefaultRoutines().stream()
            .map(RoutineDto::new).collect(Collectors.toList());
    }

    @GetMapping("/user/routine")
    public List<RoutineDto> getUserExerciseGoals(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        // TODO : exerciseGoalIds 를 어떻게 가져올지 고민해보자.
        return routineService.getLatestUserRoutine(userDetails.getUserId(), List.of(1L, 2L, 3L, 4L, 5L))
            .stream().map(RoutineDto::new).collect(Collectors.toList());
    }

}