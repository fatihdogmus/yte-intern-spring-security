package yte.intern.security.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.intern.security.security.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder passwordEncoder = passwordEncoder();
//		auth.inMemoryAuthentication()
//				.withUser("admin")
//				.password(passwordEncoder.encode("admin"))
//				.authorities("ADMIN")
//				.roles("ADMIN")
//				.and()
//				.withUser("user")
//				.password(passwordEncoder.encode("user"))
//				.authorities("USER")
//				.and()
//				.passwordEncoder(passwordEncoder);
//
//		System.out.println(passwordEncoder.encode("hebele"));
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
//		http
//				.authorizeRequests()
//				.antMatchers("/login").permitAll()
//				.antMatchers("/user").hasAnyAuthority("ADMIN", "USER")
//				.antMatchers("/admin").hasAuthority("ADMIN")
//				.and()
//				.formLogin();
	}

}
