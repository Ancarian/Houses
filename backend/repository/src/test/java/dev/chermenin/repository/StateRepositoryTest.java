package dev.chermenin.repository;

import dev.chermenin.dao.adress.Country;
import dev.chermenin.dao.adress.State;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class StateRepositoryTest {
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void findAllByCountry() {
        Country country = countryRepository
                .findById(1L)
                .orElseThrow(NullPointerException::new);

        List<State> states = stateRepository.findAllByCountry(country);
        if (states.size() == 0) {
            Assert.fail("states list is empty");
        }

        states.forEach(state -> {
            Assert.assertTrue(country.getName().contains(state.getCountry().getName()));
        });
    }
}