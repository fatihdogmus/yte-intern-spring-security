package tubitak.yte.securitydemo.security.login;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/login", method = RequestMethod.POST)
public class LoginController {

	private final LoginService loginService;

	public LoginController(final LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping
	public JwtResponse login(@Valid @RequestBody final JwtRequest jwtRequest) {
		return loginService.authenticate(jwtRequest);
	}
}
