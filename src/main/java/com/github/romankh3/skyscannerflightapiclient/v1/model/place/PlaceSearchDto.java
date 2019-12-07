package com.github.romankh3.skyscannerflightapiclient.v1.model.place;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * Search DTO for getting list places that match fields.
 *
 * @since 0.1
 * @author Roman Beskrovnyi
 */
@Getter
@Builder
public class PlaceSearchDto {

    /**
     * The name of the place. Required. Example "Stockholm".
     */
    @NonNull
    private String placeName;

    /**
     * The market/country your user is in. Required.
     */
    @NonNull
    private String country;

    /**
     * The currency you want the prices in. Required.
     */
    @NonNull
    private String currency;

    /**
     * The locale you want the results in (ISO locale). Required.
     */
    @NonNull
    private String locale;
}
