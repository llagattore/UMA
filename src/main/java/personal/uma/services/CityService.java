package personal.uma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.uma.dto.CityDto;
import personal.uma.entities.City;
import personal.uma.mappers.CityMapper;
import personal.uma.repositories.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CityRepository cityRepository;

    public List<CityDto> allCities(){
        List<City> cities = cityRepository.retrieveAllFetch();
        List<CityDto> citieDtos = cities.stream().map(city -> cityMapper.mapToDto(city)).collect(Collectors.toList());

        return citieDtos;
    }

    // MORE SERVICES---
}
