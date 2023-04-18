package ua.admissions.system.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExamScoreListValidator.class)
public @interface ExamScoreListValidation {
    String message() default "Missing exam scores for SubjectNames";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
