package ua.admissions.system;

import ua.admissions.system.entity.person.Admin;

import java.time.LocalDate;
import java.util.List;

public class AdminTestData {
    public static final Admin CREATED_ADMIN = new Admin("Admins Name", "Admins surname",
            LocalDate.of(1970, 1, 1), "admin@gmail.com", "someHardPassword");
    public static final Admin CREATED_ADMIN_2 = new Admin("Admins Name 2", "Admins surname 2",
            LocalDate.of(1970, 1, 1), "admin2@gmail.com", "someHardPassword2");
    public static final Admin CREATED_ADMIN_3 = new Admin("Admins Name 3", "Admins surname 3",
            LocalDate.of(1970, 1, 1), "admin3@gmail.com", "someHardPassword3");

    public static final List<Admin> ADMIN_LIST = List.of(CREATED_ADMIN, CREATED_ADMIN_2, CREATED_ADMIN_3);

    public static Admin getUpdatedAdmin(){
        Admin updatedAdmin = new Admin(CREATED_ADMIN);
        updatedAdmin.setLastName("Admins updated surname");
        updatedAdmin.setPassword("updatedSomeHardPassword");
        return updatedAdmin;
    }
}

