package yte.intern.security.usecase.login;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import yte.intern.security.usecase.login.dto.LoginRequest;
import yte.intern.security.usecase.login.dto.LoginResponse;
import yte.intern.security.security.util.JwtUtil;

@Service
@RequiredArgsConstructor
public class LoginService {

	@Value(value = "${security.jwt.secret-key}")
	private String secretKey;

	private final DaoAuthenticationProvider authenticationProvider;

	public LoginResponse login(final LoginRequest loginRequest) {

		Authentication usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

		try {
			Authentication user = authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
			String token = JwtUtil.generateToken(user, secretKey, 15);
			return new LoginResponse(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}

		return null;
	}
}
