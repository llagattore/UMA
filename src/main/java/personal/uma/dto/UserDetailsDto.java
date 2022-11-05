package personal.uma.dto;

import java.util.Date;

public class UserDetailsDto {

    private Integer userId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Character sex;
    private CityDto cityOfBirthDto;
    private CountryDto countryOfBirthDto;

//    private String city_of

    public UserDetailsDto() {
    }

    public UserDetailsDto(Integer id, String firstName, String lastName) {
        this.userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDetailsDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public CityDto getCityOfBirthDto() {
        return cityOfBirthDto;
    }

    public void setCityOfBirthDto(CityDto cityOfBirthDto) {
        this.cityOfBirthDto = cityOfBirthDto;
    }

    public CountryDto getCountryOfBirthDto() {
        return countryOfBirthDto;
    }

    public void setCountryOfBirthDto(CountryDto countryOfBirthDto) {
        this.countryOfBirthDto = countryOfBirthDto;
    }

}
