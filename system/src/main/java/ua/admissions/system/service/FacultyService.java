package ua.admissions.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.admissions.system.entity.Faculty;
import ua.admissions.system.entity.constant.FacultyName;
import ua.admissions.system.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    public Faculty findByName(FacultyName name) {
        return facultyRepository.findByName(name);
    }

    public Faculty findByNameForApplication(String name) {
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
