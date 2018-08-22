package dev.chermenin.service.dto.adress;

import dev.chermenin.dao.adress.City;
import dev.chermenin.service.dto.Dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto extends Dto {
    private String name;

    public CityDto(City city) {
        super(city);
        this.name = city.getName();
    }
}
