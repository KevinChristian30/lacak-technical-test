package com.kevinchristian.app.validation.fileextension;

import com.kevinchristian.app.constant.ErrorMessage;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = FileExtensionValidator.class)
@Target({ ElementType.FIELD , ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface FileExtension {
    String message() default ErrorMessage.INVALID_FILE_EXTENSION;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] allow();
}
