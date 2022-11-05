package personal.uma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.uma.services.UserDetailsService;

@RestController
@RequestMapping(value = "/api/user_details")
public class UserDetailsController {
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping
    ResponseEntity<Void> noMethods(){
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
