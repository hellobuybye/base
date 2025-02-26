package com.cyh.base.controller;

import com.cyh.base.dto.TestVO;
import com.cyh.base.dto.TokenInfo;
import com.cyh.base.dto.UserDto;
import com.cyh.base.service.UserService;
// import com.cyh.base.service.MemberService;
import com.cyh.base.validate.SampleValidates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

    // @GetMapping("/login")
    // public String getLoginPage(Model model,
    //                            @RequestParam(value = "error", required = false) String error,
    //                            @RequestParam(value = "exception", required = false) String exception) {
    //     model.addAttribute("error", error);
    //     model.addAttribute("exception", exception);
    //     return "/member/login";
    // }

    @PostMapping("/api/login/proc")
    @ResponseBody
    public ResponseEntity<?> loginProc(
                                // @RequestParam(value = "userId", required = true) String userId,
                                // @RequestParam(value = "password", required = true) String password
                                @RequestBody UserDto userDto
                            ) {
        
        TokenInfo tokenInfo = userService.login(userDto.getUserId(), userDto.getPassword());
        HttpHeaders header = new HttpHeaders();
        header.add(" ",""+tokenInfo.getAccessToken());
//        log.debug();
        return ResponseEntity.ok().headers(header).body(tokenInfo);
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