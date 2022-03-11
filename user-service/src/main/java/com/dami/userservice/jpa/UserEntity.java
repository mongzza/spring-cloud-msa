package com.dami.userservice.jpa;

import com.dami.userservice.dto.UserDto;
import com.dami.userservice.jpa.listener.EntityCryptoListener;
import com.dami.userservice.util.ModelMapperUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EntityListeners(EntityCryptoListener.class)
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity extends BaseEntity implements Cryptable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String email;
    
    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String userId;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "encryptValue", column = @Column(name = "encryptedPwd")),
            @AttributeOverride(name = "decryptValue", column = @Column(name = "encryptedPwd", insertable = false, updatable = false))
    })
    private CryptoColumn pwd;
    
    public static UserEntity from(UserDto userDto) {
        UserEntity userEntity = ModelMapperUtils.map(userDto, UserEntity.class);
        userEntity.pwd = CryptoColumn.from(userDto.getPwd());
        return userEntity;
    }
    
    public CryptoColumn getCryptoColumn() {
        return pwd;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getEncryptedPassword() {
        return pwd.getEncryptedValue();
    }
}
