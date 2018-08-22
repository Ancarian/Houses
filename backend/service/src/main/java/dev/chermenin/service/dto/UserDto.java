package dev.chermenin.service.dto;

import dev.chermenin.dao.Client;
import dev.chermenin.service.dto.adress.CityUserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto extends Dto {
    private String name;
    private String lastname;
    private CityUserDto city;
    private String email;
    private String phone;

    public UserDto(Client client) {
        super(client);
        this.name = client.getName();
        this.lastname = client.getLastname();
        this.city = new CityUserDto(client.getCity());
        this.email = client.getEmail();
        this.phone = client.getPhone();
    }
}
