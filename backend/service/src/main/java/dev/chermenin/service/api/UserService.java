package dev.chermenin.service.api;


import dev.chermenin.service.dto.UserDto;
import dev.chermenin.service.dto.create.UserRegistrationDto;
import dev.chermenin.service.dto.login.UserCredentialsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto findById(Long id);

    UserCredentialsDto findUserCredentialsByEmail(String email);

    Page<UserDto> findAll(Pageable pageable);

    UserDto save(UserRegistrationDto dto);

    void update(UserRegistrationDto dto);

    void deleteById(Long id);

    UserDto findByEmail(String email);
}
