package com.dami.userservice.model.response;

import com.dami.userservice.dto.UserDto;
import com.dami.userservice.util.ModelMapperUtils;
import lombok.Getter;

@Getter
public class ResponseUser {
    private String email;
    private String name;
    private String userId;
    
    public static ResponseUser from(UserDto userDto) {
        return ModelMapperUtils.map(userDto, ResponseUser.class);
    }
}
