package yte.intern.security.usecase.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.security.usecase.login.dto.LoginRequest;
import yte.intern.security.usecase.login.dto.LoginResponse;
import yte.intern.security.usecase.login.LoginService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;

	@PostMapping("/login")
	public LoginResponse login(@Valid @RequestBody final LoginRequest loginRequest) {
		return loginService.login(loginRequest);
	}
}
