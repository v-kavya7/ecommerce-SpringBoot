package com.example.E_commerce.controller;

import org.springframework.web.bind.annotation.*;
import com.example.E_commerce.service.RecommendationService;

@RestController
@RequestMapping("/api")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/recommend")
    public String recommend(@RequestParam String product) {
        return service.getRecommendations(product);
    }
}