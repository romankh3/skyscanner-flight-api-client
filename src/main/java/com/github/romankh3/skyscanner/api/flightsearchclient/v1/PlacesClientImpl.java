package com.github.romankh3.skyscanner.api.flightsearchclient.v1;

import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.PLACES_FORMAT;
import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.PLACES_KEY;
import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.UniRestUtil.get;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.place.PlaceSearchDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.place.PlacesPlaceDto;
import java.util.List;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

/**
 * {@inheritDoc}
 */
public class PlacesClientImpl implements PlacesClient {

    /**
     * {@inheritDoc}
     */
    public List<PlacesPlaceDto> retrieveListPlaces(String xRapidApiKey, PlaceSearchDto placeSearchDto) {
        HttpResponse<JsonNode> response = get(xRapidApiKey,
                String.format(PLACES_FORMAT, placeSearchDto.getCountry(), placeSearchDto.getCurrency(),
                        placeSearchDto.getLocale(), placeSearchDto.getPlaceName()));

        String jsonList = response.getBody().getObject().get(PLACES_KEY).toString();

        return UniRestUtil.readValueWrapper(jsonList, new TypeReference<List<PlacesPlaceDto>>() {
        });
    }
}










































