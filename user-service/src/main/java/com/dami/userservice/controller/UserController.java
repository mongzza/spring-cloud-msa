package com.dami.userservice.controller;

import com.dami.userservice.dto.UserDto;
import com.dami.userservice.jpa.UserEntity;
import com.dami.userservice.model.Greeting;
import com.dami.userservice.model.request.RequestUser;
import com.dami.userservice.model.response.ResponseUser;
import com.dami.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user-service")
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
    
    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers() {
        List<UserDto> users = userService.getUserByAll();
        List<ResponseUser> results = users.stream()
                                          .map(ResponseUser::from)
                                          .collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }
    
    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable String userId) {
        UserDto user = userService.getUserByUserId(userId);
        return ResponseEntity.ok(ResponseUser.from(user));
    }
}
