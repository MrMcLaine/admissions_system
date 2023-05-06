package ua.admissions.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.admissions.system.entity.ApplicationForAdmission;
import ua.admissions.system.repository.ApplicationForAdmissionRepository;

@Service
public class ApplicationForAdmissionService {

    private final Logger LOGGER = LoggerFactory.getLogger(ApplicationForAdmissionService.class);

    @Autowired
    ApplicationForAdmissionRepository applicationForAdmissionRepository;

    public void save(ApplicationForAdmission application) {
        LOGGER.info("Save application for admission : {}", application);
        applicationForAdmissionRepository.save(application);
    }
}
