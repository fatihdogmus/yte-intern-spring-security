package tubitak.yte.securitydemo.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

public class CustomUserDetailsManager implements UserDetailsManager {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public CustomUserDetailsManager(final UserRepository userRepository,
									final PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void createUser(final UserDetails user) {
		Users users = (Users) user;
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		userRepository.save(users);
	}

	@Override
	public void updateUser(final UserDetails user) {
		Users oldUser = (Users) loadUserByUsername(user.getUsername());
		Users newUser = (Users) user;
		newUser.setId(oldUser.getId());
		userRepository.save(newUser);
	}

	@Override
	public void deleteUser(final String username) {
		userRepository.deleteByUsername(username);
	}

	@Override
	public void changePassword(final String oldPassword, final String newPassword) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = (String) authentication.getPrincipal();
		Users user = (Users) loadUserByUsername(username);
		if(passwordEncoder.matches(oldPassword, user.getPassword())) {
			user.setPassword(passwordEncoder.encode(newPassword));
			userRepository.save(user);
		}
		else {
			throw new BadCredentialsException("Wrong old password is given!");
		}
	}

	@Override
	public boolean userExists(final String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(final String username) {
		return userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(username));
	}
}
