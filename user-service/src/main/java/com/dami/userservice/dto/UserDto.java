package com.dami.userservice.dto;

import com.dami.userservice.model.request.RequestUser;
import com.dami.userservice.model.response.ResponseOrder;
import com.dami.userservice.util.ModelMapperUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    
    @Setter
    private List<ResponseOrder> orders;
    
    public static UserDto from(RequestUser requestUser) {
        UserDto user = ModelMapperUtils.map(requestUser, UserDto.class);
        user.userId = UUID.randomUUID().toString();
        return user;
    }
}
