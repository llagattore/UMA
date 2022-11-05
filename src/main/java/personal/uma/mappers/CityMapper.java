package personal.uma.mappers;

import org.springframework.stereotype.Component;
import personal.uma.dto.CityDto;
import personal.uma.entities.City;

@Component
public class CityMapper {
    private CountryMapper countryMapper = new CountryMapper();  //Use @Autowired?

    public CityDto mapToDto(City city){
        if (city == null){
            return null;
        }

        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setCountryDto(countryMapper.mapToDto(city.getCountry()));

        return cityDto;
    }

    public City mapToEntity(CityDto cityDto){
        if(cityDto == null){
            return null;
        }

        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setCountry(countryMapper.mapToEntity(cityDto.getCountryDto()));

        return city;
    }
}
