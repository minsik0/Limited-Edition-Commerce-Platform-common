package com.sparta.multi_module.common.jwt;

import com.sparta.multi_module.common.exception.BusinessException;
import com.sparta.multi_module.common.exception.ErrorCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

public class DefaultJwtProvider implements JwtProvider {

    private final Key key;
    private final long accessTokenExpirationTime;

    public DefaultJwtProvider(String secretKey, long accessTokenExpirationTime) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        this.accessTokenExpirationTime = accessTokenExpirationTime;
    }

    @Override
    public String generateToken(UUID userId, String role) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + accessTokenExpirationTime)
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public UUID getUserId(String token) {
        return UUID.fromString(parseClaims(token).getSubject());
    }

    @Override
    public String getRole(String token) {
        String role = parseClaims(token).get("role", String.class);
        if (role == null) {
            throw new BusinessException(ErrorCode.INVALID_TOKEN);
        }
        return role;
    }

    private Claims parseClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException | IllegalArgumentException e) {
            throw new BusinessException(ErrorCode.INVALID_TOKEN);
        }
    }
}
