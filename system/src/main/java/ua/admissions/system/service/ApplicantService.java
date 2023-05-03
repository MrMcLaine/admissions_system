package ua.admissions.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.admissions.system.entity.Faculty;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.repository.ApplicantRepository;

import java.util.List;

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

    public Applicant findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    public List<Applicant> findAllByFaculty(Faculty faculty) {
        return repository.findAllByFaculty(faculty);
    }
}
