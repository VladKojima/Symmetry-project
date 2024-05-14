package com.jwt.service.controller;

import com.jwt.service.dto.JwtRequest;
import com.jwt.service.dto.JwtResponse;
import com.jwt.service.dto.RefreshJwtRequest;
import com.jwt.service.dto.authorization.Roles;
import com.jwt.service.service.AuthService;
import com.jwt.service.service.SecurityAccountService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthAccountController {

    private final AuthService authAccount;
    private final HttpServletResponse httpServletResponse;
    @Autowired
    private SecurityAccountService securityAccountService;

    @PostMapping("/login")
    public Roles login(@RequestBody @Valid JwtRequest authRequest) {
        JwtResponse token = authAccount.login(authRequest);
        Cookie accessToken = new Cookie("access_token", token.getAccessToken());
        accessToken.setMaxAge(Integer.MAX_VALUE);
        accessToken.setHttpOnly(false);
        accessToken.setPath("/");
        Cookie refreshToken = new Cookie("refresh_token", token.getRefreshToken());
        refreshToken.setMaxAge(Integer.MAX_VALUE);
        refreshToken.setHttpOnly(false);
        refreshToken.setPath("/");
        httpServletResponse.addCookie(accessToken);
        httpServletResponse.addCookie(refreshToken);



        return securityAccountService.findByLogin(authRequest.getLogin()).orElseThrow().getRole();
    }

    @PostMapping("/refresh")
    public ResponseEntity<Void> getNewTokenByRefresh(@RequestBody @Valid RefreshJwtRequest request) {
        JwtResponse token = authAccount.refresh(request.getRefreshToken());
        Cookie accessToken = new Cookie("access_token", token.getAccessToken());
        accessToken.setMaxAge(Integer.MAX_VALUE);
        accessToken.setHttpOnly(false);
        accessToken.setPath("/");
        Cookie refreshToken = new Cookie("refresh_token", token.getRefreshToken());
        refreshToken.setMaxAge(Integer.MAX_VALUE);
        refreshToken.setHttpOnly(false);
        refreshToken.setPath("/");
        httpServletResponse.addCookie(accessToken);
        httpServletResponse.addCookie(refreshToken);
        
        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> postMethodName() {
        Cookie accessToken = new Cookie("access_token", null);
        accessToken.setMaxAge(0);
        accessToken.setHttpOnly(false);
        accessToken.setPath("/");
        Cookie refreshToken = new Cookie("refresh_token", null);
        refreshToken.setMaxAge(0);
        refreshToken.setHttpOnly(false);
        refreshToken.setPath("/");
        httpServletResponse.addCookie(accessToken);
        httpServletResponse.addCookie(refreshToken);
        return ResponseEntity.ok().build();
    }
    
}
