package com.dami.catalogservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/catalog-service")
public class HealthCheckController {
    
    @GetMapping("/health-check")
    public String status() {
        return "It's Working in Catalog service.";
    }
}
