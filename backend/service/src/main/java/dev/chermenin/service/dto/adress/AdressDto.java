package dev.chermenin.service.dto.adress;

import dev.chermenin.dao.adress.Adress;
import dev.chermenin.service.dto.Dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class AdressDto extends Dto {
    private String adress;
    private String city;
    private String state;
    private String country;

    public AdressDto(Adress adress) {
        //super(adress);
        this.adress = adress.getAdress();
        city = adress.getCity().getName();
        state = adress.getCity().getState().getName();
        country = adress.getCity().getState().getCountry().getName();
    }
}
