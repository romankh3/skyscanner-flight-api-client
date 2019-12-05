package com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.place;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * DTO for Place in places call.
 *
 * @since 0.1
 * @author Roman Beskrovnyi
 */
@Data
public class PlacesPlaceDto {

    @JsonProperty("PlaceId")
    private String placeId;

    @JsonProperty("PlaceName")
    private String placeName;

    @JsonProperty("CountryId")
    private String countryId;

    @JsonProperty("RegionId")
    private String regionId;

    @JsonProperty("CityId")
    private String cityId;

    @JsonProperty("CountryName")
    private String countryName;
}

