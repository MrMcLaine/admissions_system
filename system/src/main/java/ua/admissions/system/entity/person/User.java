package ua.admissions.system.entity.person;

import ua.admissions.system.entity.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class User extends AbstractBaseEntity {
    protected String firstName;
    protected String lastName;
    protected LocalDate birthday;
    protected String email;
    protected String password;
}
