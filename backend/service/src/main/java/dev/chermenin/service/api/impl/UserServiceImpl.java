package dev.chermenin.service.api.impl;

import dev.chermenin.dao.Client;
import dev.chermenin.repository.CityRepository;
import dev.chermenin.repository.UserRepository;
import dev.chermenin.service.api.UserService;
import dev.chermenin.service.api.impl.exception.ConflictException;
import dev.chermenin.service.api.impl.exception.NotFoundException;
import dev.chermenin.service.dto.UserDto;
import dev.chermenin.service.dto.create.UserRegistrationDto;
import dev.chermenin.service.dto.login.UserCredentialsDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final CityRepository cityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public UserDto findById(Long id) {
        Client client = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("client with %d id does not exists", id)));
        client.setPosts(null);
        return new UserDto(client);
    }

    @Override
    public UserCredentialsDto findUserCredentialsByEmail(String email) {
        Client client = userRepository.findByEmail(email);
        if (client == null) {
            throw new NotFoundException(String.format("client with %s email does not exists", email));
        }
        return new UserCredentialsDto(client);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        Page<Client> users = userRepository.findAll(pageable);
        users.getContent().forEach(user -> user.setPosts(null));
        return users.map(UserDto::new);
    }

    @Override
    public UserDto save(UserRegistrationDto dto) {
        if (userRepository.existsByPhone(dto.getPhone())) {
            throw new NotFoundException(String.format("client with %s phone number already exists", dto.getPhone()));
        }
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new NotFoundException(String.format("client with %s email already exists", dto.getEmail()));
        }
        Client client = convertUserRegistrationDtoToUser(dto);
        Set<Client.RoleType> roles = new HashSet<>();
        roles.add(Client.RoleType.USER);
        client.setRoles(roles);

        client = userRepository.save(client);
        return new UserDto(client);
    }

    private Client convertUserRegistrationDtoToUser(UserRegistrationDto dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setEmail(dto.getEmail());
        client.setName(dto.getName());
        client.setPhone(dto.getPhone());
        client.setPassword(passwordEncoder.encode(dto.getPassword()));
        client.setLastname(dto.getLastname());
        client.setCity(cityRepository
                .findById(dto.getCityId())
                .orElseThrow(IllegalArgumentException::new));
        return client;
    }

    @Override
    public void update(UserRegistrationDto dto) {
        if (Objects.isNull(dto.getId())) {
            throw new NotFoundException("dto contains id");
        }
        if (userRepository.existsByPhoneAndIdNot(dto.getPhone(), dto.getId())) {
            throw new ConflictException(String.format("client with %s phone number already exists", dto.getPhone()));
        }
        if (userRepository.existsByEmailAndIdNot(dto.getPhone(), dto.getId())) {
            throw new ConflictException(String.format("client with %s email already exists", dto.getEmail()));
        }

        Client client = convertUserRegistrationDtoToUser(dto);
        userRepository.save(client);
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException(String.format("client with %d id not exists", id));
        }
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto findByEmail(String email) {
        Client client = userRepository.findByEmail(email);
        if (client == null) {
            throw new NotFoundException(String.format("client with %s email not exists", email));
        }
        client.setPosts(null);
        return new UserDto(client);
    }
}
