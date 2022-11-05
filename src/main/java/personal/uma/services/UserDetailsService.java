package personal.uma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.uma.mappers.UserDetailsMapper;
import personal.uma.repositories.UserDetailsRepository;

@Service
public class UserDetailsService {
    @Autowired
    UserDetailsMapper userDetailsMapper;
    @Autowired
    UserDetailsRepository userDetailsRepository;

    // SERVICES
}
