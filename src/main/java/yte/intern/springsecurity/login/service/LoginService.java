package yte.intern.springsecurity.login.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import yte.intern.springsecurity.login.request.LoginRequest;
import yte.intern.springsecurity.login.utils.JwtUtil;

@Service
public class LoginService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    private final AuthenticationManager authenticationManager;

    public LoginService(final AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String login(LoginRequest loginRequest) {
        var token = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

        try {
            Authentication authenticatedToken = authenticationManager.authenticate(token);
            String jwt = JwtUtil.generateToken(authenticatedToken, secretKey);
            return jwt;
        } catch (AuthenticationException ex) {

        }
        return null;
    }
}
