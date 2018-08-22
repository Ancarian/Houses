package dev.chermenin.service.dto.adress;

import dev.chermenin.dao.adress.Country;
import dev.chermenin.service.dto.Dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDto extends Dto {
    private Integer phoneCode;
    private String shortName;
    private String name;

    public CountryDto(Country country) {
        super(country);
        this.phoneCode = country.getPhoneCode();
        this.shortName = country.getShortName();
        this.name = country.getName();
    }
}
