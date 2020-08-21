package yte.intern.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.security.dto.AddUserDTO;
import yte.intern.security.entity.Authority;
import yte.intern.security.entity.Users;
import yte.intern.security.repository.AuthorityRepository;
import yte.intern.security.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

	private final AuthorityRepository authorityRepository;
	private final UserRepository userRepository;

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
				null,addUserDTO.getUsername(),addUserDTO.getPassword(),
				authorities,true,true,true,true);

		userRepository.save(users);

		return "Başarıyla kullanıcı eklendi!";
	}
}
