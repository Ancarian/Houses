package dev.chermenin.service.api.impl;

import dev.chermenin.dao.adress.Country;
import dev.chermenin.repository.CountryRepository;
import dev.chermenin.service.api.CountryService;
import dev.chermenin.service.dto.adress.CountryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public List<CountryDto> findAll() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream().map(CountryDto::new).collect(Collectors.toList());
    }

    @Override
    public List<CountryDto> findByShortNameOrName(String name) {
        List<Country> countries = countryRepository.findByShortNameLikeOrNameLike(name, name);
        return countries.stream().map(CountryDto::new).collect(Collectors.toList());
    }
}
