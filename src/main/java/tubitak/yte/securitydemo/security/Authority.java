package tubitak.yte.securitydemo.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
public class Authority implements GrantedAuthority {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "authorities")
	private Set<Users> userEntities;

	private String authority;
}
