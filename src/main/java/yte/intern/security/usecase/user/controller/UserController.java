package yte.intern.security.usecase.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.security.usecase.user.UserService;
import yte.intern.security.usecase.user.dto.AddUserDTO;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/addUser")
	@PreAuthorize("permitAll()")
	public String addUser(@RequestBody AddUserDTO addUserDTO) {
		return userService.addUser(addUserDTO);
	}
}
