package com.sparta.multi_module.common.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtCommonConfig {

    @Bean
    public JwtProvider jwtProvider(@Value("${jwt.secret-key}") String secretKey,
                                   @Value("${jwt.access-token-expiration-ms}") long expiration) {
        return new DefaultJwtProvider(secretKey, expiration);
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(
            JwtProvider jwtProvider
    ) {
        return new JwtAuthenticationFilter(jwtProvider);
    }
}
