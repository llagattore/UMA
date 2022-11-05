package personal.uma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.uma.dto.UserDto;
import personal.uma.entities.User;
import personal.uma.mappers.UserMapper;
import personal.uma.repositories.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    public List<UserDto> allInactiveUsers(){
        List<User> users = userRepository.retrieveAllByInactiveFetchDetails();
        List<UserDto> userDtos = users.stream().map(user -> userMapper.mapToDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    public List<UserDto> byCreationDate(Date creationDate) {
        List<User> users = userRepository.retrieveAllByDateCreatedFetchDetails(creationDate);
        List<UserDto> userDots = users.stream().map(user -> userMapper.mapToDto(user)).collect(Collectors.toList());

        return userDots;
    }

    public List<UserDto> byCompanyName(String companyName) {
        List<User> users = userRepository.retrieveAllByCompanyName(companyName);
        List<UserDto> userDtos = users.stream().map(user -> userMapper.mapToDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    public void save(UserDto userDto) {
        User user = userMapper.mapToEntity(userDto);
        userRepository.save(user);
    }

    public void update(UserDto userDto){
        User user = userRepository.getReferenceById(userDto.getId());
        userMapper.updateUser(user, userDto);
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public Boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public Boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public Boolean userExists(Integer userId) {
        return userRepository.existsById(userId);
    }

    // MORE SERVICES---
}
