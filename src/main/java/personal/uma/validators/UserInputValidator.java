package personal.uma.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import personal.uma.dto.UserDto;
import personal.uma.services.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserInputValidator implements Validator {
    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        Integer userId = userDto.getId();
        if(userId != null){
            validateOnUpdate(userDto, errors);
        }
        else validateOnInsert(userDto, errors);
    }

    private void validateOnUpdate(UserDto userDto, Errors errors){
        if(userDto.getUsername() != null){
            validateUsername(userDto.getUsername(), errors);
        }
        if(userDto.getPassword() != null){
            validatePassword(userDto.getPassword(), errors);
        }
        if(userDto.getEmail() != null){
            validateEmail(userDto.getEmail(), errors);
        }
    }

    private void validateOnInsert(UserDto userDto, Errors errors){
        validateUsername(userDto.getUsername(), errors);
        validatePassword(userDto.getPassword(), errors);
        validateEmail(userDto.getEmail(), errors);
    }

    private void validateUsername(String username, Errors errors) {
        if(username == null){
            errors.rejectValue("username", "null-username", "Username can not be null");
            return;
        }

        Matcher matcher = inputRegexes[0].matcher(username);
        if (matcher.find()){
            errors.rejectValue("username", "invalid-username", "Only letters, numbers and . allowed [a-z A-z 0-9 .]");
            return;
        }

        Boolean exists = userService.usernameExists(username);
        if (exists){
            errors.rejectValue("username", "username-taken", "Username is taken " +
                    "(comparison is case insensitive: cannot have similar usernames)");
        }
    }

    private void validatePassword(String password, Errors errors) {
        if(password == null){
            errors.rejectValue("password", "null-password", "Password can not be null");
            return;
        }

        Matcher matcher = inputRegexes[1].matcher(password);
        if (!matcher.find()){
            errors.rejectValue("password", "invalid-password",
                    "Must be at least 8 characters long and contain one of each: " +
                            "Capital letter, Lower case letter, Number, Special character");
        }
    }

    private void validateEmail(String email, Errors errors) {
        if(email == null){
            errors.rejectValue("email", "null-email", "Email can not be null");
            return;
        }

        Matcher matcher = inputRegexes[2].matcher(email);
        if (!matcher.find()){
            errors.rejectValue("email", "invalid-email", "Must be a valid email form");
            return;
        }

        Boolean exists = userService.emailExists(email);
        if (exists){
            errors.rejectValue("email", "email-taken", "Email is taken");
        }
    }

    private static final Pattern[] inputRegexes = new Pattern[4];
    static {
        inputRegexes[0] = Pattern.compile("[^a-zA-Z0-9.]");
        inputRegexes[1] = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?\\d)" +
                "(?=.*?[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?]).{8,}$");
        inputRegexes[2] = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
}




