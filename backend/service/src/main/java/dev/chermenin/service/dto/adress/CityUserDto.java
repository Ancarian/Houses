package dev.chermenin.service.dto.adress;

import dev.chermenin.dao.adress.City;
import dev.chermenin.service.dto.Dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CityUserDto extends Dto {
    private String city;
    private String state;
    private String country;

    public CityUserDto(City city) {
        //super(city);
        this.city = city.getName();
        state = city.getState().getName();
        country = city.getState().getCountry().getName();
    }
}
