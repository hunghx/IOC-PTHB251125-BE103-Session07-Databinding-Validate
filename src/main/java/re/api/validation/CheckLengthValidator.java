package re.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckLengthValidator implements ConstraintValidator<CheckLength, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // nếu true thì ko vi phạm, nếu false thì vi phạm
        if (value == null || value.length() < 6){
            // lỗi
            return false;
        }
        return true;
    }
}
