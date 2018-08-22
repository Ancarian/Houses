package dev.chermenin.service.api;

import dev.chermenin.service.dto.adress.StateDto;

import java.util.List;

public interface StateService {
    List<StateDto> findByCountryId(Long countryId);
}
