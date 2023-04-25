package ua.admissions.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.repository.ApplicantRepository;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository repository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public void save(Applicant applicant) {
        applicant.setPassword(bCryptPasswordEncoder.encode(applicant.getPassword()));
        applicant.setPassword(bCryptPasswordEncoder.encode(applicant.getPasswordConfirm()));
        repository.save(applicant);
    }
}
