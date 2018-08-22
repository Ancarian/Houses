package dev.chermenin.repository;

import dev.chermenin.dao.adress.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findAllByNameContains(String name);

    List<Country> findByShortName(String name);

    List<Country> findByShortNameLikeOrNameLike(String shortName, String name);
}
