package yte.intern.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.security.dto.AddUserDTO;
import yte.intern.security.service.UserService;

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
