package dev.chermenin.service.api.impl;

import dev.chermenin.dao.adress.City;
import dev.chermenin.repository.CityRepository;
import dev.chermenin.repository.StateRepository;
import dev.chermenin.service.api.CityService;
import dev.chermenin.service.api.impl.exception.NotFoundException;
import dev.chermenin.service.dto.adress.CityDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final StateRepository stateRepository;

    @Override
    public List<CityDto> findAllByStateId(Long stateId) {
        List<City> cities = cityRepository
                .findAllByState(stateRepository
                        .findById(stateId)
                        .orElseThrow(
                                () -> new NotFoundException(String.format("city with %d id does not exists", stateId))));
        return cities.stream().map(CityDto::new).collect(Collectors.toList());
    }
}
