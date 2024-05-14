package com.jwt.service.dto.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String accessToken;

    private String refreshToken;

    private Roles role;
}
