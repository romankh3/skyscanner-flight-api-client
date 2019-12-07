package com.github.romankh3.skyscannerflightapiclient.v1.model.browse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Data transfer object for Place in Browse calls.
 *
 * @since 0.1
 * @author Roman Beskrovnyi
 */
@Data
public class BrowsePlaceDto {

    @JsonProperty("PlaceId")
    private String placeId;

    @JsonProperty("IataCode")
    private String iataCode;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("SkyscannerCode")
    private String skyscannerCode;

    @JsonProperty("CityName")
    private String cityName;

    @JsonProperty("CityId")
    private String cityId;

    @JsonProperty("CountryName")
    private String countryName;
}
