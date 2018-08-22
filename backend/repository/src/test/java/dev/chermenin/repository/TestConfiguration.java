package dev.chermenin.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "dev.chermenin")
@EntityScan(basePackages = "dev.chermenin")
@EnableJpaRepositories(basePackages = {"dev.chermenin"})
@TestPropertySource("classpath:application.yml")
public class TestConfiguration {

}