package dev.chermenin.api.configuration.security;

import dev.chermenin.dao.Client;
import dev.chermenin.service.dto.login.UserCredentialsDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ancarian on 18.02.2018.
 */
public class JwtUserDetails implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private Set<GrantedAuthority> authorities;

    public JwtUserDetails(UserCredentialsDto userCredentialsDto) {
        this.id = userCredentialsDto.getId();
        this.username = userCredentialsDto.getUsername();
        this.password = userCredentialsDto.getPassword();
        this.authorities = new HashSet<>();

        for (Client.RoleType role : userCredentialsDto.getRoles()) {
            this.authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}