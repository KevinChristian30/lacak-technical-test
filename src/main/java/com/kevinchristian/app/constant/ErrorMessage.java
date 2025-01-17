package com.kevinchristian.app.constant;

public class ErrorMessage {
    private ErrorMessage() {
        throw new IllegalStateException(DO_NOT_INSTANTIATE);
    }

    public static final String DO_NOT_INSTANTIATE = "Don't Instantiate";
    public static final String INVALID_FILE_EXTENSION = "Invalid File Extension";
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String VALIDATION_ERROR = "Validation Error";
    public static final String MISSING_PARAMETER_X = "Missing Parameter: ";
}
