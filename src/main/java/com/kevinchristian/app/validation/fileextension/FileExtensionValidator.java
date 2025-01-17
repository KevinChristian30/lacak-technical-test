package com.kevinchristian.app.validation.fileextension;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileExtensionValidator implements ConstraintValidator<FileExtension, MultipartFile> {
    private Set<String> extensions;

    @Override
    public void initialize(FileExtension fileExtension) {
        extensions = new HashSet<>(Arrays.asList(fileExtension.allow()));
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext constraintValidatorContext) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        return extensions.stream().anyMatch(ext -> ext.equalsIgnoreCase(extension));
    }

}
