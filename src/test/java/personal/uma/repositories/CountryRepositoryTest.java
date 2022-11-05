package personal.uma.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import personal.uma.UmaApplication;
import personal.uma.entities.City;
import personal.uma.entities.Country;

import java.util.List;

@SpringBootTest(classes = UmaApplication.class)
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;


//    @Test
//    public void insertsCountryWithCitiesCollection(){
//
//        City city = new City();
//        city.setName("imagine");
//
//        City city1 = new City();
//        city1.setName("imagine1");
//
//        List<City> cities = List.of(city, city1);
//
//        Country country = new Country();
//        country.setName("Imaginary");
//        country.setCode("ign");
//        country.setCities(cities);
//    }
}
