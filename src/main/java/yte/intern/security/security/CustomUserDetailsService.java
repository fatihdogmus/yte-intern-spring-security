package yte.intern.security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yte.intern.security.usecase.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}
}
