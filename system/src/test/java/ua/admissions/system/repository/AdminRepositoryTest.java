package ua.admissions.system.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.admissions.system.entity.person.Admin;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
        checkAdminFields(savedAdmin, CREATED_ADMIN);
    }

    @Test
    void update() {
        Admin admin = repository.save(CREATED_ADMIN);
        Long id = admin.getId();
        Admin updated = getUpdatedAdmin();
        updated.setId(id);
        repository.save(getUpdatedAdmin());
        checkAdminFields(updated, getUpdatedAdmin());
    }

    @Test
    void deleteById() {
        Admin admin = repository.save(CREATED_ADMIN);
        Long adminId = admin.getId();
        repository.deleteById(adminId);
        assertFalse(repository.existsById(adminId));
    }

    @Test
    void findById() {
        Admin admin = repository.save(CREATED_ADMIN);
        Long adminId = admin.getId();
        Admin foundAdmin = repository.getReferenceById(adminId);
        checkAdminFields(foundAdmin, CREATED_ADMIN);
    }

    @Test
    void findAll() {
        repository.save(CREATED_ADMIN);
        repository.save(CREATED_ADMIN_2);
        repository.save(CREATED_ADMIN_3);

        List<Admin> admins = repository.findAll();
        checkAdminLists(admins, ADMIN_LIST);
    }

    @Test
    void findByIdNotFound() {
        assertFalse(repository.existsById(Long.MAX_VALUE));
    }

/*    @Test
    void duplicateMailCreate() {
        repository.save(CREATED_ADMIN);
        assertThrows(DataIntegrityViolationException.class, () -> repository.save(CREATED_ADMIN));
    }*/

    void checkAdminFields(Admin a1, Admin a2) {
        Assertions.assertNotNull(a1);
        Assertions.assertNotNull(a1.getId());
        Assertions.assertEquals(a2.getFirstName(), a1.getFirstName());
        Assertions.assertEquals(a2.getLastName(), a1.getLastName());
        Assertions.assertEquals(a2.getBirthday(), a1.getBirthday());
        Assertions.assertEquals(a2.getEmail(), a1.getEmail());
        Assertions.assertEquals(a2.getPassword(), a1.getPassword());
    }

    void checkAdminLists(List<Admin> al1, List<Admin> al2) {
        Assertions.assertEquals(al1.size(), al2.size());
        for (int i = 0; i < al1.size(); i++) {
            checkAdminFields(al1.get(i), al2.get(i));
        }
    }
}