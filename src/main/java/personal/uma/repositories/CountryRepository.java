package personal.uma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import personal.uma.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
    //  CUSTOM QUERIES---
}