package personal.uma.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import personal.uma.UmaApplication;
import personal.uma.entities.City;

import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Logger;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = UmaApplication.class)
public class CityRepositoryTest {
    Logger log = Logger.getAnonymousLogger();

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;


    @Test
    public void returnsAllCities(){

        List<City> cities = cityRepository.retrieveAll();

        Assertions.assertNotNull(cities, "cities is null");
        Assertions.assertTrue(cities.size()!=0, "cities is empty");
        log.info(String.format("cities size is %d", cities.size()));
    }
}
