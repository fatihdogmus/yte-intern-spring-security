package yte.intern.springsecurity.login.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springsecurity.login.request.LoginRequest;
import yte.intern.springsecurity.login.service.LoginService;

import javax.validation.Valid;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(final LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody final LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }
}
