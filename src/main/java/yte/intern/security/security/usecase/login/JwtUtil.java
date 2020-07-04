package yte.intern.security.security.usecase.login;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class JwtUtil {

	public static String generateToken(Authentication user, String secretKey, Integer expirationDay) {

		return Jwts.builder()
				.setSubject(user.getName())
				.claim("authorities", getAuthorities(user))
				.setIssuedAt(new Date())
				.setExpiration(calculateExpirationDate(expirationDay))
				.signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
				.compact();
	}

	private static List<String> getAuthorities(Authentication user) {
		return user.getAuthorities()
				.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(toList());
	}

	private static Date calculateExpirationDate(Integer expirationDay) {
		Instant expirationTime = LocalDate.now()
				.plusDays(expirationDay)
				.atStartOfDay()
				.atZone(ZoneId.systemDefault())
				.toInstant();

		return Date.from(expirationTime);
	}
}
