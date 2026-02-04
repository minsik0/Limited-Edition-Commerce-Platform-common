package com.sparta.multi_module.common.security;

import java.util.UUID;

public interface AuthenticatedUser {
    UUID getUserId();
    String getRole();
}