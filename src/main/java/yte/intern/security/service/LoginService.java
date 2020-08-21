package yte.intern.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import yte.intern.security.dto.LoginRequest;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final AuthenticationProvider authenticationProvider;

	public String login(LoginRequest loginRequest) {
		var authenticationToken = new UsernamePasswordAuthenticationToken(
				loginRequest.getUsername(), loginRequest.getPassword());

		try {
			Authentication authenticaiton = authenticationProvider.authenticate(authenticationToken);

			return "Başarıyla giriş yapıldı!";
		} catch (AuthenticationException ex) {
			ex.printStackTrace();
		}

		return "Girişte bir problem oldu!";
	}
}
