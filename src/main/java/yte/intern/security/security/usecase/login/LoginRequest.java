package yte.intern.security.security.usecase.login;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@RequiredArgsConstructor
public class LoginRequest {

	@NotEmpty
	private final String username;
	@NotEmpty
	private final String password;

}
