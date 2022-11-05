package personal.uma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import personal.uma.entities.User;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    All Users
    @Query(value = "select user " +
            "from User as user")
    List<User> retrieveAll();

    @Query(value = "select user " +
            "from User as user left join fetch user.userDetails")
    List<User> retrieveAllFetchDetails();

    @Query(value = "select user " +
            "from User as user left join fetch user.company")
    List<User> retrieveAllFetchCompany();
// ---------------------------------------


//    Users by Company Id
//    @Query(value = "select user " +
//            "from User as user " +
//            "where company.id = :company_id")
//    List<User> retrieveAllByCompanyId(@Param("company_id") Integer companyId);    MUST JOIN COMPANY

//    @Query(value = "select user " +
//            "from User as user left join fetch user.userDetails " +
//            "where company.id = :company_id")
//    List<User> retrieveAllByCompanyIdFetchDetails(@Param("company_id") Integer companyId);    MUST JOIN COMPANY

    @Query(value = "select user " +
            "from User as user left join fetch user.company " +
            "where user.company.id = :company_id")
    List<User> retrieveAllByCompanyIdFetchCompany(@Param("company_id") Integer companyId);

    //    Users by Company Name
    @Query(value = "select user " +
            "from User as user join Company as company on user.company.id = company.id " +
            "left join fetch user.userDetails " +
            "where company.name = :company_name")
    List<User> retrieveAllByCompanyName(@Param("company_name") String companyName);

//    @Query(value = "select user " +
//            "from User as user left join fetch user.userDetails " +
//            "where company.name = :company_name")
//    List<User> retrieveAllByCompanyNameFetchDetails(@Param("company_id") String companyName); MUST JOIN COMPANY
// ---------------------------------------


//    Users by Inactive
    @Query(value = "select user " +
            "from User as user " +
            "where user.active = FALSE")
    List<User> retrieveAllByInactive();

    @Query(value = "select user " +
            "from User as user left join fetch user.userDetails " +
            "where user.active = FALSE")
    List<User> retrieveAllByInactiveFetchDetails();

    @Query(value = "select user " +
            "from User as user left join fetch user.company " +
            "where user.active = FALSE")
    List<User> retrieveAllByInactiveFetchCompany();
// ---------------------------------------


//    Users by Date Created

    @Query(value = "select user " +
            "from User as user " +
            "where cast(user.dateCreated as date) = :creation_date")
    List<User> retrieveAllByDateCreated(@Param("creation_date") Date creationDate);

    @Query(value = "select user " +
            "from User as user left join fetch user.userDetails " +
            "where cast(user.dateCreated as date) = :creation_date")
    List<User> retrieveAllByDateCreatedFetchDetails(@Param("creation_date") Date creationDate);

    @Query(value = "select user " +
            "from User as user left join fetch user.company " +
            "where cast(user.dateCreated as date) = cast(:creation_date as date)")
    List<User> retrieveAllByDateCreatedFetchCompany(@Param("creation_date") Date creationDate);
// ---------------------------------------

//    Delete by Id
    @Modifying
    @Query("delete from User as user " +
            "where user.id = :id")
    void deleteById(@Param("id") Integer id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    void deleteByUsername(String username);
}
