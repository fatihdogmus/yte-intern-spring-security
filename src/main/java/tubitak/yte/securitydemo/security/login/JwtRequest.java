package tubitak.yte.securitydemo.security.login;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@RequiredArgsConstructor
public class JwtRequest {

	@NotEmpty
	private final String username;
	@NotEmpty
	private final String password;

}
