package com.talpods.routesortingservice.controller;

import com.talpods.routesortingservice.model.TalPodBoardingPassRequest;
import com.talpods.routesortingservice.service.RouteSortingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/route")
@AllArgsConstructor
public class RouteSortingController {
    private RouteSortingService routeSortingService;

    @PostMapping(value = "/sort")
    public List<String> sortTheRoutes(@RequestBody List<TalPodBoardingPassRequest> talPodBoardingPassRequests) {
        return routeSortingService.sortTheRoutes(talPodBoardingPassRequests);
    }

    @GetMapping
    public String ping() {
        return "application is UP and Running";
    }
}
