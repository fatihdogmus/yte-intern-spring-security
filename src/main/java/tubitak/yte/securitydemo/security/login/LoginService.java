package tubitak.yte.securitydemo.security.login;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	private final UserDetailsManager customUserDetailsManager;
	private final DaoAuthenticationProvider authenticationProvider;

	public LoginService(@Qualifier("customUserDetailsManager") final UserDetailsManager customUserDetailsManager, final DaoAuthenticationProvider authenticationProvider) {
		this.customUserDetailsManager = customUserDetailsManager;
		this.authenticationProvider = authenticationProvider;
	}


	public JwtResponse authenticate(final JwtRequest jwtRequest) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
				UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword());

		try {
			authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
			String token = JwtUtil.generateToken(jwtRequest.getUsername(), "asdaafsfafsafasfasfasfasfasfasfasfasfsfa", 15);
			return new JwtResponse(token);
		}
		catch (AuthenticationException e) {
			e.printStackTrace();
		}

		return null;
	}
}
