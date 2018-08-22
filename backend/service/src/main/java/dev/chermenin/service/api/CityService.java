package dev.chermenin.service.api;

import dev.chermenin.service.dto.adress.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> findAllByStateId(Long stateId);
}
