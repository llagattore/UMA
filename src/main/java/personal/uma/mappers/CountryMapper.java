package personal.uma.mappers;

import org.springframework.stereotype.Component;
import personal.uma.dto.CountryDto;
import personal.uma.entities.Country;

@Component
public class CountryMapper {

    public CountryDto mapToDto(Country country){
        if (country == null){
            return null;
        }

        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        countryDto.setCode(country.getCode());

        return countryDto;
    }

    public Country mapToEntity(CountryDto countryDto){
        System.out.println("IN MAPPER");

        if(countryDto == null){
            return null;
        }

        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());
        country.setCode(countryDto.getCode());

        return country;
    }
}
