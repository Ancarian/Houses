package dev.chermenin.repository;


import dev.chermenin.dao.Client;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Client, Long> {
    Client findByPhone(String phone);

    @EntityGraph(value = "userWithRoles", type = EntityGraph.EntityGraphType.LOAD)
    Client findByEmail(String email);

    boolean existsByPhoneAndIdNot(String phone, Long id);

    boolean existsByEmailAndIdNot(String email, Long id);

    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);
}
