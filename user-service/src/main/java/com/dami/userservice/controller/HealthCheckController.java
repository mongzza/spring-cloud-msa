package com.dami.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    
    @GetMapping("/health-check")
    public String status() {
        return "It's Working in User service.";
    }
}
