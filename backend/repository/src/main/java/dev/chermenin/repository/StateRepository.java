package dev.chermenin.repository;

import dev.chermenin.dao.adress.Country;
import dev.chermenin.dao.adress.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    List<State> findAllByCountry(Country country);
}
