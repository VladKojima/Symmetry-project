//package com.jwt.service.config.filter;
//
//import com.jwt.service.dto.JwtAuthentication;
//import com.jwt.service.dto.authorization.Account;
//import com.jwt.service.service.SecurityAccountService;
//import com.jwt.service.tool.JwtHelper;
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;
//
//import java.util.Objects;
//
//import static com.jwt.service.config.filter.Constant.ACCOUNT_NOT_FOUND;
//import static com.jwt.service.config.filter.Constant.HASH_PASSWORD;
//
//@Component
//@RequiredArgsConstructor
//public class AccountJwtFilter extends GenericFilterBean {
//
//    private final JwtHelper jwtHelper;
//    private final SecurityAccountService securityAccountService;
//
//    @SneakyThrows
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
//        String token = FilterUtil.getTokenFromRequest((HttpServletRequest) servletRequest);
//        if (Objects.nonNull(token) && jwtHelper.validateAccessToken(token)) {
//            Claims claims = jwtHelper.getAccessClaims(token);
//
//            String password = claims.get(HASH_PASSWORD, String.class);
//            String login = claims.getSubject();
//
//            Account account = securityAccountService.findByLogin(login)
//                    .orElseThrow(() -> new UsernameNotFoundException(ACCOUNT_NOT_FOUND));
//
//            if (FilterUtil.validatePassword(password, account)) {
//                JwtAuthentication jwtAuthentication = new JwtAuthentication(account);
//                jwtAuthentication.setAuthenticated(true);
//                SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);
//            }
//        }
//            filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//}
