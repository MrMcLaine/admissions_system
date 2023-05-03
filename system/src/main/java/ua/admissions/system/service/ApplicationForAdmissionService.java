package ua.admissions.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.admissions.system.entity.ApplicationForAdmission;
import ua.admissions.system.repository.ApplicationForAdmissionRepository;

@Service
public class ApplicationForAdmissionService {

    @Autowired
    ApplicationForAdmissionRepository applicationForAdmissionRepository;

    public void save(ApplicationForAdmission application) {
        applicationForAdmissionRepository.save(application);
    }
}
