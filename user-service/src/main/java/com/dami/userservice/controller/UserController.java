package com.dami.userservice.controller;

import com.dami.userservice.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {
    
    private final Greeting greeting;
    
    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
    }
}
