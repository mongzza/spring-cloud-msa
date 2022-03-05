package com.dami.userservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ModelMapperUtils {
    
    private static final ModelMapper mapper = new ModelMapper();
    static {
        mapper.getConfiguration()
              .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
              .setFieldMatchingEnabled(true)
              .setMatchingStrategy(MatchingStrategies.STRICT);
    }
    
    public static <T> T map(Object source, Class<T> targetType) {
        return mapper.map(source, targetType);
    }
}
