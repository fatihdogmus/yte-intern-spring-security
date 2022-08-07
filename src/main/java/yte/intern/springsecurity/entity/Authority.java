package yte.intern.springsecurity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;

    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }
}
