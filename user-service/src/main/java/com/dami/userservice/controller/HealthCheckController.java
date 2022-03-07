package com.dami.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user-service")
public class HealthCheckController {
    
    private final Environment env;
    
    @GetMapping("/health-check")
    public String status() {
        return String.format("It's Working in User service on PORT %s", env.getProperty("local.server.port"));
    }
}
