package personal.uma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import personal.uma.dto.UserDto;
import personal.uma.exceptions.ValidationException;
import personal.uma.services.UserService;
import personal.uma.validators.UserInputValidator;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInputValidator userInputValidator;

    @GetMapping(value = "/inactive")
    ResponseEntity<List<UserDto>> allInactive(){
        List<UserDto> users = userService.allInactiveUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{creation_date}")
    ResponseEntity<List<UserDto>> allOnCreationDate(@PathVariable(value = "creation_date")
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                    Date creationDate){

        List<UserDto> users = userService.byCreationDate(creationDate);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<UserDto>> allByCompany(@RequestParam(value = "company_name") String companyName){
        List<UserDto> users = userService.byCompanyName(companyName);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto userDto) throws ValidationException{
        if(userDto.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Errors validationErrors = new BeanPropertyBindingResult(userDto, "userDto");
        ValidationUtils.invokeValidator(userInputValidator, userDto, validationErrors);
        if(validationErrors.hasErrors()){
            throw new ValidationException(validationErrors);
        }

        userService.save(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UserDto userDto) throws ValidationException{
        Integer userId = userDto.getId();
        if(userId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!userService.userExists(userId)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Errors validationErrors = new BeanPropertyBindingResult(userDto, "userDto");
        ValidationUtils.invokeValidator(userInputValidator, userDto, validationErrors);
        if(validationErrors.hasErrors()){
            throw new ValidationException(validationErrors);
        }

        userService.update(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //  MORE METHODS---
}
