package personal.uma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.uma.dto.CompanyDto;
import personal.uma.services.CompanyService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    ResponseEntity<List<CompanyDto>> all(){
        List<CompanyDto> companies = companyService.allCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    //  MORE METHODS---
}
