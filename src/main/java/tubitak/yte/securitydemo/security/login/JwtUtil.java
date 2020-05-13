package tubitak.yte.securitydemo.security.login;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.time.LocalDate;
import java.util.Date;

public class JwtUtil {
	public static String generateToken(String username, String secretKey, Integer expirationDay) {

		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(expirationDay)))
				.signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
				.compact();
	}
}
