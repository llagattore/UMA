package personal.uma.repositories;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import personal.uma.UmaApplication;
import personal.uma.entities.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;


@SpringBootTest(classes = UmaApplication.class)
public class UserRepositoryTest {
    Logger log = Logger.getAnonymousLogger();

    @Autowired
    private UserRepository userRepository;

    @Test
    public void returnsAllUsers(){
        List<User> users = userRepository.findAll();

        Assertions.assertNotNull(users, "users is null");
        Assertions.assertTrue(users.size()!=0, "users is empty");
    }

    @Transactional
    @Test
    public void insertsRecord(){
        User user = new User();
        user.setUsername("userFromTest");
        user.setPassword("ICanPutWhatIWantFromHere");
        user.setEmail("user.test@email.com");
        userRepository.save(user);

        Assertions.assertNotNull(userRepository.existsByUsername("userFromTest"));
        userRepository.deleteByUsername("userFromTest");
        Assertions.assertFalse(userRepository.existsByUsername("userFromTest"));
    }
}
