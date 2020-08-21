package yte.intern.security.usecase.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "authorities")
	private Set<Users> users;

	private String authority;


}
