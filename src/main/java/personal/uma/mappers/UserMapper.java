package personal.uma.mappers;

import org.springframework.stereotype.Component;
import personal.uma.dto.UserDto;
import personal.uma.entities.User;

import java.util.function.Consumer;

@Component
public class UserMapper {

    private CompanyMapper companyMapper = new CompanyMapper();
    private UserDetailsMapper userDetailsMapper = new UserDetailsMapper();


    public UserDto mapToDto(User user){
        if (user == null){
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setDateCreated(user.getDateCreated());
        userDto.setActive(user.getActive());
        userDto.setCompanyDto(companyMapper.mapToDto(user.getCompany()));
        userDto.setUserDetailsDto(userDetailsMapper.mapToDto(user.getUserDetails()));

        return userDto;
    }

    public User mapToEntity(UserDto userDto){
        if(userDto == null){
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setDateCreated(userDto.getDateCreated());
        user.setActive(userDto.getActive());
        user.setCompany(companyMapper.mapToEntity(userDto.getCompanyDto()));
        user.setUserDetails(userDetailsMapper.mapToEntity(userDto.getUserDetailsDto()));

        return user;
    }

    public void updateUser(User user, UserDto userDto) {
        setIfNotNull(user::setUsername, userDto.getUsername());
        setIfNotNull(user::setUsername, userDto.getUsername());
        setIfNotNull(user::setPassword, userDto.getPassword());
        setIfNotNull(user::setEmail, userDto.getEmail());
        setIfNotNull(user::setDateCreated, userDto.getDateCreated());
        setIfNotNull(user::setActive, userDto.getActive());
        setIfNotNull(user::setCompany, companyMapper.mapToEntity(userDto.getCompanyDto()));
        setIfNotNull(user::setUserDetails, userDetailsMapper.mapToEntity(userDto.getUserDetailsDto()));
    }
    private static <V> void setIfNotNull(Consumer<V> setter, V value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}

