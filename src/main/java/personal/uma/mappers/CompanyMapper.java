package personal.uma.mappers;

import org.springframework.stereotype.Component;
import personal.uma.dto.CompanyDto;
import personal.uma.entities.Company;

@Component
public class CompanyMapper {
//    private UserMapper userMapper = new UserMapper(); TO IMPLEMENT

    public CompanyDto mapToDto(Company company){
        if(company == null){
            return null;
        }

        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setDescription(company.getDescription());
//        companyDto.setUsers(userMapper.mapToDto(company.getUsers());      TO IMPLEMENT -> USE .stream.map().collect()

        return companyDto;
    }

    public Company mapToEntity(CompanyDto companyDto){
        if(companyDto == null){
            return null;
        }

        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());
//        company.setUsers(userMapper.mapToEntity(companyDto.getUsers));    TO IMPLEMENT -> USE .stream.map().collect()

        return company;
    }
}
