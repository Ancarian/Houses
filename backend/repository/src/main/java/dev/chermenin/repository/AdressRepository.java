package dev.chermenin.repository;

import dev.chermenin.dao.adress.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Long> {

}
