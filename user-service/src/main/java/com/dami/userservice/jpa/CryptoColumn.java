package com.dami.userservice.jpa;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class CryptoColumn {
    
    private String encryptedValue;
    private String decryptedValue;
    
    public static CryptoColumn from(String pwd) {
        return new CryptoColumn(null, pwd);
    }
    
    public void encrypt(BCryptPasswordEncoder encoder) {
        if (StringUtils.isEmpty(encryptedValue)) {
            this.encryptedValue = encoder.encode(decryptedValue);
        }
    }
}
