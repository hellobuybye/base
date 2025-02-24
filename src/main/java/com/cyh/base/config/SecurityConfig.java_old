package com.cyh.base.config;


import com.cyh.base.handler.AuthFailureHandler;
import com.cyh.base.handler.AuthSuccessHandler;
import com.cyh.base.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @EnableGlobalMethodSecurity(prePostEnabled = true)
 * 특정 페이지에 특정 권한이 있는 유저만 접근을 허용할 경우
 * 권한 및 인증을 미리 체크하는 설정을 활성화함.
 */
@RequiredArgsConstructor
@EnableWebSecurity // 시큐리티 필터 등록
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;

    private final AuthSuccessHandler authSuccessHandler;

    private final AuthFailureHandler authFailureHandler;

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public BCryptPasswordEncoder encryptPassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(encryptPassword());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Session
        /*
        http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/", "/login/**", "/js/**", "/css/**", "/image/**").permitAll() // 해당 경로들은 접근을 허용
                    .anyRequest() // 다른 모든 요청은
                    .authenticated() // 인증된 유저만 접근을 허용
                .and()
                    .formLogin() // 로그인 폼은
                    .loginPage("/login") // 해당 주소로 로그인 페이지를 호출한다.
                    .loginProcessingUrl("/login/action") // 해당 URL로 요청이 오면 스프링 시큐리티가 가로채서 로그인처리를 한다. -> loadUserByName
                    .successHandler(authSuccessHandler) // 성공시 요청을 처리할 핸들러
                    .failureHandler(authFailureHandler) // 실패시 요청을 처리할 핸들러
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃 URL
                    .logoutSuccessUrl("/login") // 성공시 리턴 URL
                    .invalidateHttpSession(true) // 인증정보를 지우하고 세션을 무효화
                    .deleteCookies("JSESSIONID", "remember-me") // JSESSIONID, remember-me 쿠키 삭제
                    .permitAll()
                .and()
                    .sessionManagement()
                    .maximumSessions(1) // 세션 최대 허용 수 1, -1인 경우 무제한 세션 허용
                    .maxSessionsPreventsLogin(false) // true면 중복 로그인을 막고, false면 이전 로그인의 세션을 해제
                    .expiredUrl("/login?error=true&exception=Have been attempted to login from a new place. or session expired") // 세션이 만료된 경우 이동 할 페이지를 지정
                .and()
                    .and().rememberMe() // 로그인 유지
                    .alwaysRemember(false) // 항상 기억할 것인지 여부
                    .tokenValiditySeconds(600) // in seconds, 10분 유지
                    .rememberMeParameter("remember-me")
                // 401
                .and().exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                // 403 exception handling
                .and().exceptionHandling().accessDeniedPage("/login");

         */


        //JWT
        http

                .httpBasic().disable()
                .csrf().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()

                    .antMatchers("/", "/login/**", "/js/**", "/css/**", "/image/**").permitAll()
                    .antMatchers("/**").permitAll()
                .antMatchers("/**").permitAll()
//                    .anyRequest().authenticated()

                .and().exceptionHandling().accessDeniedPage("/login")
                .and().exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

    }


}
