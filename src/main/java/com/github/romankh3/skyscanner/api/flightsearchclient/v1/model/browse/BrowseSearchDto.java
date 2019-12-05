package com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.browse;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * DTO object for search in Browse Flight Search calls.
 *
 * @since 0.1
 * @author Roman Beskrovnyi
 */
@Getter
@Builder(builderMethodName = "hiddenBuilder")
public class BrowseSearchDto {

    @NonNull
    private String country;

    @NonNull
    private String currency;

    @NonNull
    private String locale;

    @NonNull
    private String originPlace;

    @NonNull
    private String destinationPlace;

    @NonNull
    private LocalDate outboundPartialDate;

    private LocalDate inboundPartialDate;
}
