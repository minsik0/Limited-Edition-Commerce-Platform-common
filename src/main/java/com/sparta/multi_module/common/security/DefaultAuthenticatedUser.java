package com.sparta.multi_module.common.security;


import java.util.UUID;

public class DefaultAuthenticatedUser implements AuthenticatedUser {

    private final UUID userId;
    private final String role;

    public DefaultAuthenticatedUser(UUID userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    @Override
    public UUID getUserId() {
        return userId;
    }

    @Override
    public String getRole() {
        return role;
    }
}
