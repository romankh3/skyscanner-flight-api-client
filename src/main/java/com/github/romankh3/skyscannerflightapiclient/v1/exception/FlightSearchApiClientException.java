package com.github.romankh3.skyscannerflightapiclient.v1.exception;

import com.github.romankh3.skyscannerflightapiclient.v1.model.validation.ValidationErrorDto;
import java.util.List;

/**
 * A {@link RuntimeException} that is thrown in case of an flight monitoring failures.
 *
 * @author Roman Beskrovnyi
 * @since 0.1
 */
public final class FlightSearchApiClientException extends RuntimeException {

    private List<ValidationErrorDto> validationErrorDtos;

    /**
     * Constructs a new {@link FlightSearchApiClientException} with the specified detail message and cause.
     * Note that the detail message associated with cause is not automatically incorporated in this {@link
     * FlightSearchApiClientException}'s detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     * @param throwable the cause (which is saved for later retrieval by the Throwable.getCause() method).
     * (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public FlightSearchApiClientException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructs a new {@link FlightSearchApiClientException} with specified collection of the
     * {@link ValidationErrorDto} objects.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     * @param errors the collection of the {@link ValidationErrorDto} which contain errors from Skyscanner API.
     */
    public FlightSearchApiClientException(String message, List<ValidationErrorDto> errors) {
        super(message);
        this.validationErrorDtos = errors;
    }
}
