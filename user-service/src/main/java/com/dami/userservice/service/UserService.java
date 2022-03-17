package com.dami.userservice.service;

import com.dami.userservice.dto.UserDto;
import com.dami.userservice.exception.NotFoundException;
import com.dami.userservice.jpa.UserEntity;
import com.dami.userservice.jpa.UserRepository;
import com.dami.userservice.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity findUser = userRepository.findByEmail(username)
                                            .orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(findUser.getEmail(), findUser.getEncryptedPassword(),
                        true, true, true, true,
                        new ArrayList<>());
    }
    
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
    
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                             .stream()
                             .map(user -> ModelMapperUtils.map(user, UserDto.class))
                             .collect(Collectors.toList());
    }
    
    public UserDto getUserDetailsByEmail(String email) {
        return userRepository.findByEmail(email)
                             .map(user -> ModelMapperUtils.map(user, UserDto.class))
                             .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
