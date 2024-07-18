package yte.intern.springsecurity.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springsecurity.login.service.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/logout")
    public void logout() {
        authenticationService.logout();
    }
}
