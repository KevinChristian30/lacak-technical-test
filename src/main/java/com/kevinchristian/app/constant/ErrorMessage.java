package com.kevinchristian.app.constant;

public class ErrorMessage {
    private ErrorMessage() {
        throw new IllegalStateException("Don't Instantiate");
    }

    public static final String INVALID_FILE_EXTENSION = "Invalid File Extension";
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String VALIDATION_ERROR = "Validation Error";
}
