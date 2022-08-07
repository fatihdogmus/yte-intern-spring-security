package yte.intern.springsecurity.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import yte.intern.springsecurity.controller.LoginRequest;

@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;

    public LoginService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String login(LoginRequest loginRequest) {
        Authentication token = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        try {
            Authentication authenticatedUserInformation = authenticationManager.authenticate(token);
            SecurityContext newContext = SecurityContextHolder.createEmptyContext();
            newContext.setAuthentication(authenticatedUserInformation);
            SecurityContextHolder.setContext(newContext);
            return "Login is successfull";
        }
        catch (AuthenticationException e) {
            return e.getMessage();
        }
    }
}
