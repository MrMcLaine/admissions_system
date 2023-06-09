package ua.admissions.system.entity.person;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ua.admissions.system.entity.AbstractBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "users_type", discriminatorType = DiscriminatorType.STRING)
public class User extends AbstractBaseEntity {
    @NotBlank
    @Column(name = "first_name")
    protected String firstName;
    @NotBlank
    @Column(name = "last_name")
    protected String lastName;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDate birthday;
    @NotBlank
    @Email
    @Column(unique = true)
    protected String email;
    @NotBlank
    @Column
    protected String password;
    protected String passwordConfirm;
    @Column(name = "users_type", insertable = false, updatable = false)
    private String userType;

    public User(User user) {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.birthday = user.birthday;
        this.email = user.email;
        this.password = user.password;
        this.passwordConfirm = user.passwordConfirm;
    }

    public User(String firstName, String lastName, LocalDate birthday, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, LocalDate birthday, String email, String password, String passwordConfirm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        if (!super.equals(o)) return false;

        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (getBirthday() != null ? !getBirthday().equals(user.getBirthday()) : user.getBirthday() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        return getPassword() != null ? getPassword().equals(user.getPassword()) : user.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}
