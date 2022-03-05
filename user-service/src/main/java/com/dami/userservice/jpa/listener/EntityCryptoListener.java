package com.dami.userservice.jpa.listener;

import com.dami.userservice.jpa.BaseEntity;
import com.dami.userservice.jpa.Cryptable;
import com.dami.userservice.jpa.CryptoColumn;
import com.dami.userservice.jpa.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class EntityCryptoListener {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @PrePersist
    @PreUpdate
    public void encrypt(BaseEntity entity) {
        if (entity instanceof Cryptable) {
            CryptoColumn cryptoColumn = ((Cryptable) entity).getCryptoColumn();
            cryptoColumn.encrypt(passwordEncoder);
        }
    }
    
}
