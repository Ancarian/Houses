package dev.chermenin.service.dto.login;

import dev.chermenin.dao.Client;
import dev.chermenin.service.dto.Dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserCredentialsDto extends Dto {
    private String username;
    private String password;
    private Set<Client.RoleType> roles;


    public UserCredentialsDto(Client client) {
        super(client);
        this.username = client.getEmail();
        this.password = client.getPassword();
        this.roles = client.getRoles();
    }
}
