package personal.uma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.uma.dto.CompanyDto;
import personal.uma.entities.Company;
import personal.uma.mappers.CompanyMapper;
import personal.uma.repositories.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyDto> allCompanies(){
        List<Company> companies = companyRepository.retrieveAll();
        List<CompanyDto> companyDtos =
                companies.stream().map(company -> companyMapper.mapToDto(company)).collect(Collectors.toList());

        return companyDtos;
    }

    // MORE SERVICES---
}
