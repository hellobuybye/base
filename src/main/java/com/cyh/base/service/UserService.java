package com.cyh.base.service;

import com.cyh.base.dto.TestVO;
import com.cyh.base.dto.TokenInfo;
import com.cyh.base.dto.UserDto;
import com.cyh.base.mapper.UserMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.security.auth.message.AuthException;

import com.cyh.base.config.JwtTokenProvider;
// import com.cyh.base.entity.Member;
// import com.cyh.base.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// import javax.validation.Valid;

import static java.util.Objects.isNull;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService implements UserDetailsService {

    // private final MemberRepository memberRepository;

    @Autowired
    private UserMapper userMapper;

    
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        // Member member = memberRepository.findByEmail(username);

        UserDto user = userMapper.selectLoginUser(userId);

        if(isNull(user)){
            throw new UsernameNotFoundException("Not Found account");
        }

        return user;
    }

    @Transactional
    public TokenInfo login(String userId, String password) {

        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, password);

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매소드가 실행될 때 loadUserByUsername 메소드도 실행됨
        // Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        Authentication authentication = null;
        try {
            authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken); // 인증 수행
        } catch (AuthenticationException e) {
            log.error("Authentication failed: {}", e.getMessage());
            throw new BadCredentialsException("Authentication failed");
        }

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        // 4. 사용자 정보 함께 반환
        UserDto user = (UserDto) authentication.getPrincipal();        
        user.setPassword(null);        
        tokenInfo.setUser(user);

        return tokenInfo;
    }

    public TokenInfo refreshAccessToken(String refreshToken){
        // 1. 리프레시 토큰 검증
        if (isNull(refreshToken) ) {
            throw new BadCredentialsException("empty refresh token");
        }

        if(!jwtTokenProvider.validateToken(refreshToken)){
            throw new JwtException("invalid refresh token");
        }

        // 2. 리프레시 토큰을 통해 Authentication 객체 얻기
        // Authentication authentication = jwtTokenProvider.getAuthentication(refreshToken);
        
        Claims claims = jwtTokenProvider.parseClaims(refreshToken);        
        UserDto user = (UserDto)loadUserByUsername(claims.getSubject());
        
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        // UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(claims.getSubject(), "");
        // Authentication authentication = null;         
        // Authentication authentication2 = null;
        // try {
        //     authentication2 = authenticationManagerBuilder.getObject().authenticate(authentication); // 인증 수행
        // } catch (AuthenticationException e) {
        //     log.error("Authentication failed: {}", e.getMessage());
        //     throw new BadCredentialsException("Authentication failed");
        // }
        
        // 3. 새로운 액세스 토큰과 리프레시 토큰 생성
        TokenInfo newTokenInfo = jwtTokenProvider.generateToken(authentication);

        // // 4. 사용자 정보 함께 반환        
        user.setPassword(null);        
        newTokenInfo.setUser(user);
        
        return newTokenInfo;

    }

    
}
