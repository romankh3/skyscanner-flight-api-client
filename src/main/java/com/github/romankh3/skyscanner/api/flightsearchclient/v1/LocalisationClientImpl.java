package com.github.romankh3.skyscanner.api.flightsearchclient.v1;

import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.COUNTRIES_FORMAT;
import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.COUNTRIES_KEY;
import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.CURRENCIES_FORMAT;
import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.CURRENCIES_KEY;
import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.get;
import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.readValueWrapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.localisation.CountryDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.localisation.CurrencyDto;
import java.util.List;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

/**
 * {@inheritDoc}
 */
public class LocalisationClientImpl implements LocalisationClient {

    /**
     * {@inheritDoc}
     */
    public List<CountryDto> retrieveCountries(String locale, String xRapidApiKey) {
        HttpResponse<JsonNode> response = get(xRapidApiKey, String.format(COUNTRIES_FORMAT, locale));
        String jsonList = response.getBody().getObject().get(COUNTRIES_KEY).toString();
        return readValueWrapper(jsonList, new TypeReference<List<CountryDto>>() {
        });
    }

    /**
     * {@inheritDoc}
     */
    public List<CurrencyDto> retrieveCurrencies(String xRapidApiKey) {
        HttpResponse<JsonNode> response = get(xRapidApiKey, CURRENCIES_FORMAT);
        String jsonList = response.getBody().getObject().get(CURRENCIES_KEY).toString();
        return readValueWrapper(jsonList, new TypeReference<List<CurrencyDto>>() {
        });
    }
}
