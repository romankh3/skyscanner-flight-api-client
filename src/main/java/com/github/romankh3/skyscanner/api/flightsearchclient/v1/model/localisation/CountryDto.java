package com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.localisation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Data transfer object for Country.
 *
 * @since 0.1
 * @author Roman Beskrovnyi
 */
@Data
public class CountryDto {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Name")
    private String name;
}