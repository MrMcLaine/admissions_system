package ua.admissions.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.admissions.system.entity.Faculty;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.repository.ApplicantRepository;

import java.util.List;

import static ua.admissions.system.util.AdminUtil.changeEnabledForList;

@Service
public class ApplicantService {
    private final Logger LOGGER = LoggerFactory.getLogger(ApplicantService.class);
    @Autowired
    private ApplicantRepository repository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public void save(Applicant applicant) {
        LOGGER.info("Save applicant {} : ", applicant);
        applicant.setPassword(bCryptPasswordEncoder.encode(applicant.getPassword()));
        applicant.setPassword(bCryptPasswordEncoder.encode(applicant.getPasswordConfirm()));
        repository.save(applicant);
    }

    public Applicant findByEmail(String email) {
        LOGGER.info("Find applicant {} by email: ", email);
        return repository.findByEmail(email).orElse(null);
    }

    public List<Applicant> findAllByFaculty(Faculty faculty) {
        LOGGER.info("Find all applicants by faculty {}:", faculty);
        return repository.findAllByFaculty(faculty);
    }

    public void changeEnabledForEnrolled(List<Applicant> applicants, Faculty faculty){
        LOGGER.info("Change enabled to true for all enrolled applicants on the faculty {}:", faculty);
        List<Applicant> allByFaculty = repository.findAllByFaculty(faculty);
        repository.saveAll(changeEnabledForList(allByFaculty, applicants));
    }
}
