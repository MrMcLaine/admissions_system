package ua.admissions.system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.entity.person.User;
import ua.admissions.system.repository.ApplicantRepository;

import java.util.Optional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ApplicantRepository repository;

    public CustomUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Applicant> userOptional = repository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new CustomUserDetails(user, user.getUserType());
        }

        throw new UsernameNotFoundException("No user present with useremail:" + email);
    }

}

