package ua.admissions.system;

import ua.admissions.system.entity.person.Admin;

import java.time.LocalDate;

public class AdminTestData {

    public static final String FIRST_NAME_ADMIN = "Admins Name";
    public static final String LAST_NAME_ADMIN = "Admins surname";
    public static final LocalDate BIRTHDAY_ADMIN = LocalDate.of(1970, 1, 1);
    public static final String EMAIL_ADMIN = "admin@gmail.com";
    public static final String PASSWORD_ADMIN = "someHardPassword";
    public static final Admin CREATED_ADMIN = new Admin(FIRST_NAME_ADMIN, LAST_NAME_ADMIN,
            BIRTHDAY_ADMIN, EMAIL_ADMIN, PASSWORD_ADMIN);
}

