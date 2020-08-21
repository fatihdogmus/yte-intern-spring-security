package yte.intern.security.usecase.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yte.intern.security.usecase.user.entity.Authority;
import yte.intern.security.usecase.user.entity.Users;
import yte.intern.security.usecase.user.repository.AuthorityRepository;
import yte.intern.security.usecase.user.repository.UserRepository;
import yte.intern.security.usecase.user.dto.AddUserDTO;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

	private final AuthorityRepository authorityRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public String addUser(AddUserDTO addUserDTO) {
		Set<Authority> authorities = addUserDTO
				.getAuthorities()
				.stream()
				.map(authority -> new Authority(null, new HashSet<>(), authority))
				.collect(Collectors.toSet());

		authorities.forEach(authority -> System.out.println(authority.getId()));

		authorityRepository.saveAll(authorities);

		authorities.forEach(authority -> System.out.println(authority.getId()));

		Users users = new Users(
				null,addUserDTO.getUsername(),passwordEncoder.encode(addUserDTO.getPassword()),
				authorities,true,true,true,true);

		userRepository.save(users);

		return "Başarıyla kullanıcı eklendi!";
	}
}
