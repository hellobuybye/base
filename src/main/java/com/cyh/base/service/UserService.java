package com.cyh.base.service;

import com.cyh.base.dto.TestVO;
import com.cyh.base.dto.TokenInfo;
import com.cyh.base.dto.UserDto;
import com.cyh.base.mapper.UserMapper;
import com.cyh.base.config.JwtTokenProvider;
// import com.cyh.base.entity.Member;
// import com.cyh.base.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// import javax.validation.Valid;

import static java.util.Objects.isNull;

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
            throw new RuntimeException("Authentication failed");
        }

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }

    
}
