package com.dami.userservice.model.response;

import com.dami.userservice.dto.UserDto;
import com.dami.userservice.util.ModelMapperUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {
    private String email;
    private String name;
    private String userId;
    
    private List<ResponseOrder> orders;
    
    public static ResponseUser from(UserDto userDto) {
        return ModelMapperUtils.map(userDto, ResponseUser.class);
    }
}
