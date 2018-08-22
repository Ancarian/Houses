package dev.chermenin.repository;

import dev.chermenin.dao.adress.City;
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
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepository stateRepository;

    @Test
    public void findAllByStateIsLike() {
        State state = stateRepository
                .findById(1L)
                .orElseThrow(NullPointerException::new);

        List<City> cities = cityRepository
                .findAllByState(state);

        if (cities.size() == 0) {
            Assert.fail("cities list is empty");
        }
        cities.forEach(city -> {
            Assert.assertTrue(city.getState().getName().contains(state.getName()));
        });

    }
}

