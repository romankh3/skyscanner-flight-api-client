package com.github.romankh3.skyscanner.api.flightsearchclient.v1;

import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.CURRENCIES_KEY;
import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.PLACES_KEY;
import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.get;
import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.readValueWrapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.browse.BrowseFlightPricesResponseDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.browse.BrowsePlaceDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.browse.BrowseSearchDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.browse.CarrierDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.browse.QuoteDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.localisation.CurrencyDto;
import java.util.List;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

/**
 * {@inheritDoc}
 */
public class BrowseFlightPricesClientImpl implements BrowseFlightPricesClient {

    public static final String BROWSE_QUOTES_FORMAT = "/apiservices/browsequotes/v1.0/%s/%s/%s/%s/%s/%s";
    public static final String OPTIONAL_BROWSE_QUOTES_FORMAT = BROWSE_QUOTES_FORMAT + "?inboundpartialdate=%s";

    public static final String QUOTES_KEY = "Quotes";
    public static final String ROUTES_KEY = "Routes";
    public static final String DATES_KEY = "Dates";
    public static final String CARRIERS_KEY = "Carriers";

    @Override
    public BrowseFlightPricesResponseDto browseQuotes(String xRapidApiKey, BrowseSearchDto searchDto) {
        HttpResponse<JsonNode> response = searchDto.getInboundPartialDate() == null ?
                get(xRapidApiKey, String
                        .format(BROWSE_QUOTES_FORMAT, searchDto.getCountry(), searchDto.getCurrency(),
                                searchDto.getLocale(), searchDto.getOriginPlace(), searchDto.getDestinationPlace(),
                                searchDto.getOutboundPartialDate())) :
                get(xRapidApiKey, String
                        .format(OPTIONAL_BROWSE_QUOTES_FORMAT, searchDto.getCountry(), searchDto.getCurrency(),
                                searchDto.getLocale(), searchDto.getOriginPlace(), searchDto.getDestinationPlace(),
                                searchDto.getOutboundPartialDate(), searchDto.getInboundPartialDate()));

        return mapToObject(response);
    }

    private BrowseFlightPricesResponseDto mapToObject(HttpResponse<JsonNode> response) {
        BrowseFlightPricesResponseDto flightPricesDto = new BrowseFlightPricesResponseDto();
        flightPricesDto.setQuotas(readValueWrapper(response.getBody().getObject().get(QUOTES_KEY).toString(),
                new TypeReference<List<QuoteDto>>() {
                }));
        flightPricesDto.setCarriers(readValueWrapper(response.getBody().getObject().get(CARRIERS_KEY).toString(),
                new TypeReference<List<CarrierDto>>() {
                }));
        flightPricesDto
                .setCurrencies(readValueWrapper(response.getBody().getObject().get(CURRENCIES_KEY).toString(),
                        new TypeReference<List<CurrencyDto>>() {
                        }));
        flightPricesDto.setPlaces(readValueWrapper(response.getBody().getObject().get(PLACES_KEY).toString(),
                new TypeReference<List<BrowsePlaceDto>>() {
                }));
        return flightPricesDto;
    }
}
