package com.jwt.service.service;

import com.jwt.service.dto.JwtRequest;
import com.jwt.service.dto.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest authRequest);

    JwtResponse refresh(String refreshToken);

}
