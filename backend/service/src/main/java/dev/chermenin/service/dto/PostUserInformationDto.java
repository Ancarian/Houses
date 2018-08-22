package dev.chermenin.service.dto;

import dev.chermenin.dao.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostUserInformationDto extends Dto {
    private String name;
    private String lastname;
    private String email;
    private String phone;

    public PostUserInformationDto(Client client) {
        //super(client);
        this.name = client.getName();
        this.lastname = client.getLastname();
        this.email = client.getEmail();
        this.phone = client.getPhone();
    }
}
