package com.cyh.base.config;

import com.cyh.base.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @EnableGlobalMethodSecurity(prePostEnabled = true)
 * 특정 페이지에 특정 권한이 있는 유저만 접근을 허용할 경우
 * 권한 및 인증을 미리 체크하는 설정을 활성화함.
 * ==> deprecated로 인해  EnableMethodSecurity 로 변경. 정상 작동여부는 확인 필요
 */

@RequiredArgsConstructor
@EnableWebSecurity // 시큐리티 필터 등록
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    // private final UserService memberService;

    // private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public BCryptPasswordEncoder encryptPassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))             
            .csrf(csrf -> csrf.disable())  // CSRF 비활성화
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll()
                .requestMatchers("/login/**").permitAll()
                // .anyRequest().authenticated()
            )
            .exceptionHandling(exceptions -> exceptions
                .authenticationEntryPoint((request, response, authException) ->
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"))
            );
            // .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
            
            

        return http.build();

        // http
        //     .csrf(csrf -> csrf.disable())
        //     .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        //     .authorizeHttpRequests(auth -> auth
        //         .requestMatchers("/", "/login/**", "/js/**", "/css/**", "/image/**").permitAll()
        //         // .requestMatchers("/api/admin/**").hasRole("ADMIN")
        //         // .requestMatchers("/api/user/**").hasRole("USER")
        //         .anyRequest().authenticated()
        //     )
        //     .exceptionHandling(exceptions -> exceptions
        //         .authenticationEntryPoint((request, response, authException) ->
        //             response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"))
        //     );
        //     // .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        // return http.build();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8080"); // 허용할 클라이언트 도메인
        configuration.addAllowedMethod("GET"); // 허용할 HTTP 메서드
        configuration.addAllowedMethod("POST");
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("DELETE");
        configuration.addAllowedMethod("OPTIONS");
        configuration.addAllowedHeader("*"); // 모든 헤더 허용
        configuration.setAllowCredentials(true); // 쿠키 전송 허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 모든 경로에 대해 설정

        return source;
    }
}
