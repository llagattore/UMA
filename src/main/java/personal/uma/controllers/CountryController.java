package personal.uma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.uma.services.CountryService;

@RestController
@RequestMapping(value = "/api/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<Void> noMethods(){return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
