package yte.intern.security.usecase.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddUserDTO {

	private String username;
	private String password;

	private List<String> authorities;

}
