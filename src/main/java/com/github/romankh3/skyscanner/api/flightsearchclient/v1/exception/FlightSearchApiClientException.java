package com.github.romankh3.skyscanner.api.flightsearchclient.v1.exception;

import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.validation.ValidationErrorsDto;
import java.util.List;

/**
 * A {@link RuntimeException} that is thrown in case of an flight monitoring failures.
 *
 * @since 0.1
 * @author Roman Beskrovnyi
 */
public final class FlightSearchApiClientException extends RuntimeException {

    private List<ValidationErrorsDto> validationErrorDtos;

    public FlightSearchApiClientException(String message) {
        super(message);
    }

    public FlightSearchApiClientException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public FlightSearchApiClientException(String message, List<ValidationErrorsDto> errors) {
        super(message);
        this.validationErrorDtos = errors;
    }
}
