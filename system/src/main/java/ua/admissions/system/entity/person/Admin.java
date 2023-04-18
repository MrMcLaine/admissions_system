package ua.admissions.system.entity.person;

import ua.admissions.system.entity.constant.Role;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends User {
    private final Role role = Role.ADMIN;
}
