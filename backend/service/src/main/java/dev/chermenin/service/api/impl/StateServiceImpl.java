package dev.chermenin.service.api.impl;

import dev.chermenin.dao.adress.State;
import dev.chermenin.repository.CountryRepository;
import dev.chermenin.repository.StateRepository;
import dev.chermenin.service.api.StateService;
import dev.chermenin.service.api.impl.exception.NotFoundException;
import dev.chermenin.service.dto.adress.StateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StateServiceImpl implements StateService {
    private final StateRepository stateRepository;
    private final CountryRepository countryRepository;

    @Override
    public List<StateDto> findByCountryId(Long countryId) {
        List<State> states = stateRepository.findAllByCountry(countryRepository
                .findById(countryId)
                .orElseThrow(
                        () -> new NotFoundException(String.format("city with %d id does not exists", countryId))));
        return states.stream().map(StateDto::new).collect(Collectors.toList());
    }
}
