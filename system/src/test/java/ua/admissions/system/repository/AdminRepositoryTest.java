package ua.admissions.system.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.admissions.system.entity.person.Admin;

import static ua.admissions.system.AdminTestData.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdminRepositoryTest {

    @Autowired
    private AdminRepository repository;

    @Test
    void create() {
        Admin savedAdmin = repository.save(CREATED_ADMIN);

        Assertions.assertNotNull(savedAdmin);
        Assertions.assertNotNull(savedAdmin.getId());
        Assertions.assertEquals(FIRST_NAME_ADMIN, savedAdmin.getFirstName());
        Assertions.assertEquals(LAST_NAME_ADMIN, savedAdmin.getLastName());
        Assertions.assertEquals(BIRTHDAY_ADMIN, savedAdmin.getBirthday());
        Assertions.assertEquals(EMAIL_ADMIN, savedAdmin.getEmail());
        Assertions.assertEquals(PASSWORD_ADMIN, savedAdmin.getPassword());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByIdNotFound() {
    }

    @Test
    void createWithIllegalArg() {
    }
}