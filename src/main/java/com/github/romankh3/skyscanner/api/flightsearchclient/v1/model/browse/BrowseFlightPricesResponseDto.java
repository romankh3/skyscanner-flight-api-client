package com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.browse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.localisation.CurrencyDto;
import java.util.List;
import lombok.Data;

/**
 * Data transfer object for response of the browse flight search.
 *
 * @since 0.1
 * @author Roman Beskrovnyi
 */
@Data
public class BrowseFlightPricesResponseDto {

    @JsonProperty("Quotes")
    private List<QuoteDto> quotas;

    @JsonProperty("Places")
    private List<BrowsePlaceDto> places;

    @JsonProperty("Carrier")
    private List<CarrierDto> carriers;

    @JsonProperty("Currencies")
    private List<CurrencyDto> currencies;
}
