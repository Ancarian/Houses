package dev.chermenin.repository;

import dev.chermenin.dao.adress.City;
import dev.chermenin.dao.adress.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByState(State state);
}
