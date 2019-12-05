package com.github.romankh3.skyscanner.api.flightsearchclient.v1;

import com.github.romankh3.skyscanner.api.flightsearchclient.v1.exception.FlightSearchApiClientException;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.localisation.CountryDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.localisation.CurrencyDto;
import java.util.List;

/**
 * Retrieve the market countries that we support. Most suppliers (airlines, travel agents and car hire dealers) set
 * their fares based on the market (or country of purchase). It is therefore necessary to specify the market country in
 * every query.
 *
 * @author Roman Beskrovnyi
 * @since 0.1
 */
public interface LocalisationClient {

    /**
     * Retrieve the market countries that SkyScanner flight search API support. Most suppliers (airlines,
     * travel agents and car hire dealers) set their fares based on the market (or country of purchase).
     * It is therefore necessary to specify the market country in every query.
     *
     * @param locale locale of the response.
     * @return the collection of the {@link CountryDto} objects.
     */
    List<CountryDto> retrieveCountries(String locale, String xRapidApiKey) throws FlightSearchApiClientException;

    /**
     * Retrieve the currencies that we ScyScanner flight search API.
     *
     * @return the collection of the {@link CurrencyDto} objects.
     */
    List<CurrencyDto> retrieveCurrencies(String xRapidApiKey) throws FlightSearchApiClientException;

}
