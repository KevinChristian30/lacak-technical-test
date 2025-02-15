package com.kevinchristian.app.handler;

import com.kevinchristian.app.constant.ErrorMessage;
import com.kevinchristian.app.dto.response.ErrorResponseDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleDefaultException(Exception exception) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(ErrorMessage.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorResponseDTO, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationErrors(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        String errorMessage = violations.stream()
                .map(ConstraintViolation::getMessage)
                .findFirst()
                .orElse(ErrorMessage.VALIDATION_ERROR);
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(errorMessage);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponseDTO> handleMissingParams(MissingServletRequestParameterException ex) {
        String message = ErrorMessage.MISSING_PARAMETER_X + ex.getParameterName();
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(message);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
