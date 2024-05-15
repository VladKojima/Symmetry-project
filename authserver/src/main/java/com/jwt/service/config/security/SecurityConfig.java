package com.jwt.service.config.security;

import com.jwt.service.config.filter.CookieFilter;
import com.jwt.service.dto.ExpirationTime;
import com.jwt.service.dto.authorization.Roles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

        @ConfigurationProperties(prefix = "expiration-time.access")
        @Bean("accessExpirationTime")
        public ExpirationTime accessExpirationTime() {
                return new ExpirationTime();
        }

        @ConfigurationProperties(prefix = "expiration-time.refresh")
        @Bean("refreshExpirationTime")
        public ExpirationTime refreshExpirationTime() {
                return new ExpirationTime();
        }

        @Bean
        public PasswordEncoder bCryptPasswordEncoder() {
                return new CustomPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http, CookieFilter cookieFilter) throws Exception {
                http
                                .csrf(AbstractHttpConfigurer::disable)
                                .addFilterBefore(cookieFilter, BasicAuthenticationFilter.class)
                                .addFilterBefore(corsFilter(), CookieFilter.class)
                                .authorizeHttpRequests((authorize) -> authorize
                                                .requestMatchers("api/auth/login").hasRole("ANONYMOUS")
                                                .requestMatchers("api/moderator/**").hasRole(Roles.ADMIN.toString())

                                                .requestMatchers(
                                                                "api/corporation/register/*",
                                                                "api/department/create",
                                                                "api/faculty/",
                                                                "api/faculty/create",
                                                                "api/new/create",
                                                                "api/student/create",
                                                                "api/student/edit")
                                                .hasRole(Roles.MODERATOR.toString())

                                                .requestMatchers(
                                                                "api/announcement/create")
                                                .hasRole(Roles.CORPORATION.toString())

                                                .requestMatchers(
                                                                "api/announcement/response/*",
                                                                "api/student/edit")
                                                .hasRole(Roles.STUDENT.toString())

                                                .requestMatchers(
                                                                "api/corporation/request")
                                                .hasRole(Roles.REQUESTED_CORPORATION.toString())

                                                .requestMatchers(
                                                                "api/announcement",
                                                                "api/department",
                                                                "api/auth/logout",
                                                                "api/user/password",
                                                                "api/faculty",
                                                                "api/file/*",
                                                                "api/new",
                                                                "api/skill",
                                                                "api/student",
                                                                "api/student/*",
                                                                "api/tag",
                                                                "api/department")
                                                .authenticated()

                                                .anyRequest().denyAll());
                return http.build();
        }

        @Bean
        public CorsFilter corsFilter() {
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
                config.setAllowedMethods(Arrays.asList("HEAD",
                                "GET", "POST", "PUT", "DELETE", "PATCH"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
                source.registerCorsConfiguration("/**", config);
                return new CorsFilter(source);
        }
}
