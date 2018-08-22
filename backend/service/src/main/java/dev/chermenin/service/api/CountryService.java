package dev.chermenin.service.api;

import dev.chermenin.service.dto.adress.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> findAll();

    List<CountryDto> findByShortNameOrName(String name);
}
