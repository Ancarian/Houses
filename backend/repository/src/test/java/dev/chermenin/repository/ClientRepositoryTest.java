package dev.chermenin.repository;

import dev.chermenin.dao.Client;
import dev.chermenin.dao.adress.City;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class ClientRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CityRepository cityRepository;

    @Test
    public void save() {
        Client client = new Client();
        client.setEmail("email@email.com");
        client.setName("Name");
        client.setPhone("29 383 37 52");
        client.setPassword("password");
        client.setLastname("Lastname");
        client.setCity(new City());
        client.getCity().setId(1L);
        client = userRepository.save(client);
        System.out.println(cityRepository.findAll());
        Assert.assertNotNull(client.getId());
        userRepository.delete(client);
    }

    @Test
    public void findByPhone() {
        Assert.assertNotNull(userRepository.findByPhone("123123123"));
    }

    @Test
    public void findByEmail() {
        Assert.assertNotNull(userRepository.findByEmail("email"));
    }

}