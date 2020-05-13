package tubitak.yte.securitydemo.security.login;

import lombok.Getter;

@Getter
public class JwtResponse {

	private final String token;

	public JwtResponse(final String token) {
		this.token = token;
	}
}
