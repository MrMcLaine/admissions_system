package ua.admissions.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.admissions.system.entity.Faculty;
import ua.admissions.system.entity.constant.FacultyName;
import ua.admissions.system.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService {

    private final Logger LOGGER = LoggerFactory.getLogger(FacultyService.class);

    @Autowired
    FacultyRepository facultyRepository;

    public Faculty findByName(FacultyName name) {
        return facultyRepository.findByName(name);
    }

    public Faculty findByStringName(String name) {
        return facultyRepository.findByName(findFacultyName(name));
    }


    public Faculty findByNameForApplication(String name) {
        LOGGER.info("Find by faculty name {}", name);
        FacultyName facultyName = findFacultyName(name);
        if(findByName(facultyName) == null) {
            Faculty faculty = new Faculty(findFacultyName(name), 10, new ArrayList<>());
            return facultyRepository.save(faculty);
        }
        return findByName(facultyName);
    }

    private static FacultyName findFacultyName(String name) {
        List<FacultyName> facultyNames = List.of(FacultyName.values());
        for(FacultyName fN : facultyNames) {
            if(fN.name().equals(name)){
                return fN;
            }
        }
        return null;
    }
}
