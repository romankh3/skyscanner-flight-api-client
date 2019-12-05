package com.github.romankh3.skyscanner.api.flightsearchclient.v1;

import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.browse.BrowseFlightPricesResponseDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.browse.BrowseSearchDto;

/**
 * Retrieve the market countries that Skyscanner support. Most suppliers (airlines, travel agents and car hire dealers)
 * set their fares based on the market (or country of purchase). It is therefore necessary to specify the market country
 * in every query.
 *
 * @author Roman Beskrovnyi
 * @since 0.1
 */
public interface BrowseFlightPricesClient {

    /**
     * Retrieve the cheapest quotes from our cache prices.
     *
     * @param xRapidApiKey key for getting access to rapid api.
     * @param searchDto {@link BrowseSearchDto} object for search.
     * @return {@link BrowseFlightPricesResponseDto} object with all the data related to provided search dto.
     */
    BrowseFlightPricesResponseDto browseQuotes(String xRapidApiKey, BrowseSearchDto searchDto);
}
