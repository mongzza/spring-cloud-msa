package com.dami.userservice.service;

import com.dami.userservice.dto.UserDto;
import com.dami.userservice.exception.NotFoundException;
import com.dami.userservice.jpa.UserEntity;
import com.dami.userservice.jpa.UserRepository;
import com.dami.userservice.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserDto createUser(UserDto userDto) {
        UserEntity savedUser = userRepository.save(UserEntity.from(userDto));
        return ModelMapperUtils.map(savedUser, UserDto.class);
    }
    
    public UserDto getUserByUserId(String userId) {
        UserEntity findUser = userRepository.findByUserId(userId)
                                            .orElseThrow(NotFoundException::new);
    
        UserDto userDto = ModelMapperUtils.map(findUser, UserDto.class);
        userDto.setOrders(new ArrayList<>());
        return userDto;
    }
    
    public List<UserDto> getUserByAll() {
        return userRepository.findAll()
                             .stream()
                             .map(user -> ModelMapperUtils.map(user, UserDto.class))
                             .collect(Collectors.toList());
    }
}
