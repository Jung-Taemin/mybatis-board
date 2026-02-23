package com.example.mybatisboard.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private static final String[] SWAGGER_WHITELIST = {
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/v3/api-docs/**",
            "/swagger/**"
    };

    // ✅ 지금 단계(인증 아직 안 함)에서 공개로 열 경로들
    private static final String[] PUBLIC_WHITELIST = {
            "/", "/error",
            "/boards/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(form -> form.disable())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // 정적 리소스(필요시)
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()

                        // swagger
                        .requestMatchers(SWAGGER_WHITELIST).permitAll()

                        // (나중에 auth 만들면 쓰고, 지금은 있어도 무방)
                        .requestMatchers("/auth/**").permitAll()

                        // ✅ 게시판 화면 오픈
                        .requestMatchers(PUBLIC_WHITELIST).permitAll()

                        // ✅ 지금은 전부 허용 (JWT 붙이면 authenticated로 바꿀 것)
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}