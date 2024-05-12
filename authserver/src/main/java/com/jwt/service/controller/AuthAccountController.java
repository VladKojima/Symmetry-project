package com.jwt.service.controller;

import com.jwt.service.dto.JwtRequest;
import com.jwt.service.dto.JwtResponse;
import com.jwt.service.dto.RefreshJwtRequest;
import com.jwt.service.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthAccountController {

    private final AuthService authAccount;
    private final HttpServletResponse httpServletResponse;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody @Valid JwtRequest authRequest) {
            JwtResponse token = authAccount.login(authRequest);
//        Cookie accessToken = new Cookie("access_token", token.getAccessToken());
//        accessToken.setMaxAge(Integer.MAX_VALUE);
//        accessToken.setHttpOnly(false);
////        accessToken.setSecure();
//        accessToken.setPath("/");
//        Cookie refreshToken = new Cookie("refresh_token", token.getRefreshToken());
//        refreshToken.setMaxAge(Integer.MAX_VALUE);
//        refreshToken.setHttpOnly(false);
//        refreshToken.setPath("/");
//        httpServletResponse.addCookie(accessToken);
//        httpServletResponse.addCookie(refreshToken);
        return token;
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> getNewTokenByRefresh(@RequestBody @Valid RefreshJwtRequest request) {
        JwtResponse token = authAccount.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }
}
