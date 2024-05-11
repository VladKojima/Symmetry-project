package team.symmetry.ResumeBack.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Component
public class EntityValidator {
    
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public void validate(Object entity) {
        List<String> errorMessage = new ArrayList<>();

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(entity);

        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            errorMessage.add(constraintViolation.getMessage());
        }

        if (errorMessage.size() > 0) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
