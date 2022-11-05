package personal.uma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.uma.entities.Company;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    //    All Companies
    @Query(value = "select company " +
            "from Company as company")
    List<Company> retrieveAll();
}
