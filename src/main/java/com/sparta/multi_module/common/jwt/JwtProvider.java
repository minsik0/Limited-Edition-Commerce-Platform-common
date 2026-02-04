package com.sparta.multi_module.common.jwt;

import java.util.UUID;

public interface JwtProvider {

    String generateToken(UUID userId, String role);

    UUID getUserId(String token);

    String getRole(String token);
}
