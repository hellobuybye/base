package com.cyh.base.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    // private final MemberRepository memberRepository;

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        String msg = "Invalid Email or Password";

        if(exception instanceof DisabledException){
            msg = "DisabledException account";
        }else if(exception instanceof CredentialsExpiredException){
            msg = "CredentialsExpiredException account";
        }else if(exception instanceof BadCredentialsException){
            msg = "BadCredentialsException account";
        }

        setDefaultFailureUrl("login?error=true&exception=" + msg);

        super.onAuthenticationFailure(request,response,exception);
    }
}
