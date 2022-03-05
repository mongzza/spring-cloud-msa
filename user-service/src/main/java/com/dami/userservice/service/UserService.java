package com.dami.userservice.service;

import com.dami.userservice.dto.UserDto;
import com.dami.userservice.jpa.UserEntity;
import com.dami.userservice.jpa.UserRepository;
import com.dami.userservice.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserDto createUser(UserDto userDto) {
        UserEntity savedUser = userRepository.save(UserEntity.from(userDto));
        return ModelMapperUtils.map(savedUser, UserDto.class);
    }
}
