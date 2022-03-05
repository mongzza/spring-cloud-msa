package com.dami.userservice.jpa;

import com.dami.userservice.dto.UserDto;
import com.dami.userservice.util.ModelMapperUtils;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String email;
    
    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String userId;
    
    @Column(nullable = false, unique = true)
    private String encryptedPwd;
    
    public static UserEntity from(UserDto userDto) {
        UserEntity userEntity = ModelMapperUtils.map(userDto, UserEntity.class);
        userEntity.encryptedPwd = RandomStringUtils.random(10, userDto.getPwd());
        return userEntity;
    }
}
