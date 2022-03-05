package com.dami.userservice.controller;

import com.dami.userservice.dto.UserDto;
import com.dami.userservice.model.Greeting;
import com.dami.userservice.model.request.RequestUser;
import com.dami.userservice.model.response.ResponseUser;
import com.dami.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {
    
    private final Greeting greeting;
    private final UserService userService;
    
    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
    }
    
    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@Valid @RequestBody RequestUser requestUser) {
        UserDto user = userService.createUser(UserDto.from(requestUser));
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(ResponseUser.from(user));
    }
}
