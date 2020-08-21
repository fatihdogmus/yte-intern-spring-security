package yte.intern.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.security.dto.LoginRequest;
import yte.intern.security.service.LoginService;

@RestController
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;

	@PostMapping("/customLogin")
	@PreAuthorize("permitAll()")
	public String login(@RequestBody LoginRequest loginRequest) {
		return loginService.login(loginRequest);
	}
}
