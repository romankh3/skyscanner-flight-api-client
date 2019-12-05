package com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.validation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Data transfer Object for Validation Errors.
 *
 * @since 0.1
 * @author Roman Beskrovnyi
 */
@Data
public class ValidationErrorsDto {

    @JsonProperty("ParameterName")
    private String parameterName;

    @JsonProperty("ParameterValue")
    private String parameterValue;

    @JsonProperty("Message")
    private String message;
}
