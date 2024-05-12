package com.jwt.service.service.impl;

import com.jwt.service.dto.JwtRequest;
import com.jwt.service.dto.JwtResponse;
import com.jwt.service.dto.authorization.Account;
import com.jwt.service.exception.SecurityException;
import com.jwt.service.service.AuthService;
import com.jwt.service.service.SecurityAccountService;
import com.jwt.service.service.cache.Cache;
import com.jwt.service.tool.JwtHelper;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.jwt.service.config.filter.Constant.ACCOUNT_NOT_FOUND;
import static com.jwt.service.config.filter.Constant.INCORRECT_PASSWORD;
import static com.jwt.service.config.filter.Constant.INVALID_JWT_TOKEN;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtHelper jwtHelper;
    private final PasswordEncoder passwordEncoder;
    private final SecurityAccountService securityAccountService;
    private final Cache<Set<String>, String> accountCacheToken;

    @SneakyThrows
    @Override
    public JwtResponse login(JwtRequest authRequest) {
        Account account = securityAccountService.findByLogin(authRequest.getLogin())
                .orElseThrow(() -> new SecurityException(ACCOUNT_NOT_FOUND));
        if (account.getPassword().equals(passwordEncoder.encode(authRequest.getPassword()))) {
            JwtResponse jwtResponse = generateToken(account);
            accountCacheToken.add(account.getLogin(), jwtResponse.getRefreshToken());
            return jwtResponse;
        } else {
            throw new SecurityException(INCORRECT_PASSWORD);
        }
    }

    @SneakyThrows
    @Override
    public JwtResponse refresh(String refreshToken) {
        if (jwtHelper.validateRefreshToken(refreshToken)) {
            Claims claims = jwtHelper.getRefreshClaims(refreshToken);
            String login = claims.getSubject();
            Set<String> saveRefreshToken = accountCacheToken.get(login);
            if (saveRefreshToken.contains(refreshToken)) {
                Account account = securityAccountService.findByLogin(login)
                        .orElseThrow(() -> new SecurityException(ACCOUNT_NOT_FOUND));

                JwtResponse jwtResponse = generateToken(account);

                accountCacheToken.remove(account.getLogin(), refreshToken);
                accountCacheToken.add(account.getLogin(), jwtResponse.getRefreshToken());
                return jwtResponse;
            }
        }
        throw new SecurityException(INVALID_JWT_TOKEN);
    }

    protected JwtResponse generateToken(Account account) {
        String accessToken = jwtHelper.generateAccessToken(account);
        String newRefreshToken = jwtHelper.generateRefreshToken(account);
        return new JwtResponse(accessToken, newRefreshToken);
    }

}
