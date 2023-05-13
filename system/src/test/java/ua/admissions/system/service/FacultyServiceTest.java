package ua.admissions.system.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.admissions.system.entity.Faculty;
import ua.admissions.system.entity.constant.FacultyName;
import ua.admissions.system.repository.FacultyRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FacultyServiceTest {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private FacultyRepository facultyRepository;

    @Test
    public void findByName() {
        Faculty faculty = new Faculty();
        faculty.setName(FacultyName.COMPUTER_SCIENCE);
        faculty.setFixedAdmissionPlan(10);
        faculty.setApplicants(new ArrayList<>());
        facultyRepository.save(faculty);

        Faculty foundFaculty = facultyService.findByName(FacultyName.COMPUTER_SCIENCE);
        assertNotNull(foundFaculty);
        assertEquals(foundFaculty.getName(), FacultyName.COMPUTER_SCIENCE);
        assertEquals(foundFaculty.getFixedAdmissionPlan(), Integer.valueOf(10));
        assertEquals(foundFaculty.getApplicants().size(), 0);
    }

    @Test
    public void findByNameForApplication() {
        Faculty foundFaculty = facultyService.findByNameForApplication("COMPUTER_SCIENCE");
        assertNotNull(foundFaculty);
        assertEquals(foundFaculty.getName(), FacultyName.COMPUTER_SCIENCE);
        assertEquals(foundFaculty.getFixedAdmissionPlan(), Integer.valueOf(10));
        assertEquals(foundFaculty.getApplicants().size(), 0);
    }

    @Test
    public void findByStringName() {
        Faculty foundFaculty = facultyService.findByStringName("COMPUTER_SCIENCE");
        assertNotNull(foundFaculty);
        assertEquals(foundFaculty.getName(), FacultyName.COMPUTER_SCIENCE);
        assertEquals(foundFaculty.getFixedAdmissionPlan(), Integer.valueOf(10));
        assertEquals(foundFaculty.getApplicants().size(), 0);
    }
}