package personal.uma.mappers;

import org.springframework.stereotype.Component;
import personal.uma.dto.UserDetailsDto;
import personal.uma.entities.UserDetails;

@Component
public class UserDetailsMapper {

    private CityMapper cityMapper = new CityMapper();
    private CountryMapper countryMapper = new CountryMapper();

    public UserDetailsDto mapToDto(UserDetails userDetails){
        if(userDetails == null){
            return null;
        }

        UserDetailsDto userDetailsDto = new UserDetailsDto();
        userDetailsDto.setUserId(userDetails.getUserId());
        userDetailsDto.setFirstName(userDetails.getFirstName());
        userDetailsDto.setLastName(userDetails.getLastName());
        userDetailsDto.setDateOfBirth(userDetails.getDateOfBirth());
        userDetailsDto.setSex(userDetails.getSex());
        userDetailsDto.setCityOfBirthDto(cityMapper.mapToDto(userDetails.getCityOfBirth()));
        userDetailsDto.setCountryOfBirthDto(countryMapper.mapToDto(userDetails.getCountryOfBirth()));

        return userDetailsDto;
    }


    public UserDetails mapToEntity(UserDetailsDto userDetailsDto){
        if(userDetailsDto == null){
            return null;
        }

        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(userDetailsDto.getUserId());
        userDetails.setFirstName(userDetailsDto.getFirstName());
        userDetails.setLastName(userDetailsDto.getLastName());
        userDetails.setDateOfBirth(userDetailsDto.getDateOfBirth());
        userDetails.setSex(userDetailsDto.getSex());
        userDetails.setCityOfBirth(cityMapper.mapToEntity(userDetailsDto.getCityOfBirthDto()));
        userDetails.setCountryOfBirth(countryMapper.mapToEntity(userDetailsDto.getCountryOfBirthDto()));

        return userDetails;
    }
}
