package dev.chermenin.repository;

import dev.chermenin.dao.adress.Country;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void findAllByNameIsLike() {
        List<Country> countries = countryRepository.findAllByNameContains("Bel");
        if (countries.size() == 0) {
            Assert.fail("countries list is empty");
        }
        countries.forEach(country -> {
            Assert.assertTrue(country.getName().contains("Bel"));
        });
    }

    @Test
    public void findAllByShortNameIsLike() {
//        Country country = countryRepository.findByShortName("by");
//        Assert.assertEquals("by", country.getShortName());
    }
}