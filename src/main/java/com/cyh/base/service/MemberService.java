// package com.cyh.base.service;

// import com.cyh.base.dto.TestVO;
// import com.cyh.base.dto.TokenInfo;
// import com.cyh.base.config.JwtTokenProvider;
// import com.cyh.base.entity.Member;
// import com.cyh.base.entity.MemberRepository;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;


// import javax.validation.Valid;

// import static java.util.Objects.isNull;

// @RequiredArgsConstructor
// @Service
// @Slf4j
// public class MemberService implements UserDetailsService {

//     private final MemberRepository memberRepository;
//     private final AuthenticationManagerBuilder authenticationManagerBuilder;
//     private final JwtTokenProvider jwtTokenProvider;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//         Member member = memberRepository.findByEmail(username);

//         if(isNull(member)){
//             throw new UsernameNotFoundException("Not Found account");
//         }

//         return member;
//     }

//     @Transactional
//     public TokenInfo login(String username, String password) {
//         // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
//         // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
//         UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

//         // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
//         // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
//         Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

//         // 3. 인증 정보를 기반으로 JWT 토큰 생성
//         TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

//         return tokenInfo;
//     }

//     public TestVO testMethod(@Valid TestVO testVO) throws Exception{


//         return testVO;
//     }
// }
