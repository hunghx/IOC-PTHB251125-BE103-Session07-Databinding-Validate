package re.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CheckLengthValidator.class})
public @interface CheckLength { // annotation
    String message() default "Chuỗi ko được để trống và có ít hơn ̉kí tự ";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
