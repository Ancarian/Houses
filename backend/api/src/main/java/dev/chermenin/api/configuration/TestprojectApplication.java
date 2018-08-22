package dev.chermenin.api.configuration;

import dev.chermenin.dao.Client;
import dev.chermenin.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"dev.chermenin"})
@EntityScan(basePackages = {"dev.chermenin"})
@EnableJpaRepositories(basePackages = {"dev.chermenin.repository"})
public class TestprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestprojectApplication.class, args);
    }

    @Bean
    int bootstrap(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        List<Client> clients = userRepository.findAll();
        if (clients.size() == 0) {
            return 1;
        }

        clients.forEach(o -> {
            o.setPassword(passwordEncoder.encode(o.getPassword()));
            userRepository.save(o);
        });
        return 1;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
