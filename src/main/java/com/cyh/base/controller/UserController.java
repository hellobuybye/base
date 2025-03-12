package com.cyh.base.controller;

import com.cyh.base.dto.ApiResponse;
import com.cyh.base.dto.TestVO;
import com.cyh.base.dto.TokenInfo;
import com.cyh.base.dto.UserDto;
import com.cyh.base.service.UserService;
// import com.cyh.base.service.MemberService;
import com.cyh.base.validate.SampleValidates;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
// import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;



@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/login/proc")
    @ResponseBody
    public ResponseEntity<?> loginProc(
                                // @RequestParam(value = "userId", required = true) String userId,
                                // @RequestParam(value = "password", required = true) String password
                                @RequestBody UserDto userDto
                            ) {
        
        TokenInfo tokenInfo = null;
        
        
        try {
            tokenInfo = userService.login(userDto.getUserId(), userDto.getPassword());
        } catch (BadCredentialsException  e) {
            log.error("Authentication failed: {}", e.getMessage());            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("AUTH_FAIL");
        }
        HttpHeaders headers = new HttpHeaders();
        
        ResponseCookie refreshTokenCookie = ResponseCookie.from("refreshToken", tokenInfo.getRefreshToken())
            .httpOnly(true) // JavaScript에서 접근 불가
            // .secure(true) // HTTPS에서만 전송 (운영 환경에서 적용)
            .path("/") // 모든 경로에서 접근 가능
            .maxAge(60 * 60 * 24 * 7) // 7일 유지                             
            .build();

        headers.add(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString());
        
        return ResponseEntity.ok().headers(headers).body(tokenInfo);
    }

    @PostMapping("/api/login/refresh")
    public ResponseEntity<?> refreshAccessToken(HttpServletRequest request) {
        String refreshToken = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("refreshToken".equals(cookie.getName())) {
                    refreshToken = cookie.getValue();
                    break;
                }
            }
        }
        // httponly 쿠키값인 refresh token은 쿠키 기간 만료된 경우 못가져옴
        


        TokenInfo newTokenInfo = null;
        try {
            newTokenInfo = userService.refreshAccessToken(refreshToken);
        } catch (BadCredentialsException e) {   
            // No로그인 or expired token
            log.error("Authentication failed: {}", e.getMessage());            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NO_TOKEN");
        } catch(JwtException e){
            log.error("Authentication failed: {}", e.getMessage());            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("INVALID_TOKEN");
        }
    
        HttpHeaders headers = new HttpHeaders();
        ResponseCookie refreshTokenCookie = ResponseCookie.from("refreshToken", newTokenInfo.getRefreshToken())
            .httpOnly(true)
            // .secure(true) // HTTPS에서만 전송 (운영 환경에서 적용)
            .path("/")
            .maxAge(60 * 60 * 24 * 7) // 7일 유지                   
            .build();
        headers.add(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString());

        return ResponseEntity.ok().headers(headers).body(newTokenInfo);
}

    
@PostMapping("/api/logout")
public ResponseEntity<?> logout() {

        HttpHeaders headers = new HttpHeaders();
        ResponseCookie deleteCookie = ResponseCookie.from("refreshToken", "")
            .httpOnly(true)
            .secure(true)
            .path("/")
            .maxAge(0) // 즉시 만료 처리
            .sameSite("Strict")
            .build();

        headers.add(HttpHeaders.SET_COOKIE, deleteCookie.toString());        

        return ResponseEntity.ok().headers(headers).body(null);        
}

//     @GetMapping("/api/hello")
//     @ResponseBody
//     public ResponseEntity<?> testApi(Authentication authentication,
//             Model model,
//             @Validated(SampleValidates.Group1.class) TestVO testVO,
//             BindingResult result ) throws Exception {

//         ResponseEntity<?> returnData;

//         log.info("testApi Auth: " +  authentication.toString());
//         log.info("testApi model: " +  model.toString());
//         log.info("testApi testVO: " +  testVO.toString());
//         log.info("testApi result: " +  result.toString());

//         if(result.hasErrors()){
//             List<String> errors = result.getFieldErrors().stream()
//                             .map(e->e.getDefaultMessage())
//                             .collect(Collectors.toList());

// //            return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Error
//             return ResponseEntity.badRequest().body(errors);
//         }


// //        returnData = new ResponseEntity<>(memberService.testMethod(testVO), HttpStatus.OK);
//         returnData = ResponseEntity.ok().body(memberService.testMethod(testVO));
//         return returnData;
//     }

//     @GetMapping("/api/test1")
//     @ResponseBody
//     public ResponseEntity<?> test1(HttpServletRequest request,
//                                    Authentication authentication,
//                                    Model model ) throws Exception {

//         ResponseEntity<?> returnData;

// //        log.debug("testApi request: " +  request.toString());
// //        log.debug("testApi Auth: " +  authentication.toString());
// //        log.debug("testApi model: " +  model.toString());


//         returnData = ResponseEntity.ok().body("success");
//         return returnData;
//     }
}