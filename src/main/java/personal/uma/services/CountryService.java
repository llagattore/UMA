package personal.uma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.uma.mappers.CountryMapper;
import personal.uma.repositories.CountryRepository;

@Service
public class CountryService {
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private CountryRepository countryRepository;

    // SERVICES
}
