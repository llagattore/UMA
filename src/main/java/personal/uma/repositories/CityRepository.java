package personal.uma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.uma.entities.City;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    //    All Cities
    @Query(value = "select city " +
            "from City as city")
    List<City> retrieveAll();

    @Query(value = "select city " +
            "from City as city left join fetch city.country")
    List<City> retrieveAllFetch();
}