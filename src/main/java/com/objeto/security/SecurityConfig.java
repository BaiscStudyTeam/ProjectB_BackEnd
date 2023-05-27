package com.objeto.security;

import com.objeto.filter.JwtAuthenticationFilter;
import com.objeto.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().disable().formLogin().disable().csrf().disable(); // Spring Security LoginPage disable
        http.httpBasic().disable(); // rest api 만을 고려하여 기본 설정 해제
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 토큰 기반 인증이므로 세션 사용 안함
        http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class); // 필터 적용
        return http.build();
    }
}
