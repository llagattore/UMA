package personal.uma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.uma.dto.CityDto;
import personal.uma.services.CityService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    ResponseEntity<List<CityDto>> all(){
        List<CityDto> cities = cityService.allCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    //  MORE METHODS---
}