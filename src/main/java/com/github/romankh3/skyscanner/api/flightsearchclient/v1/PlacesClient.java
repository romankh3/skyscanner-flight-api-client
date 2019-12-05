package com.github.romankh3.skyscanner.api.flightsearchclient.v1;


import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.place.PlaceSearchDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.place.PlacesPlaceDto;
import java.util.List;

/**
 * Get a list of places that match a query string.
 *
 * @author Roman Beskrovnyi
 * @since 0.1
 */
public interface PlacesClient {

    /**
     * Get a list of places that match a query string based on arguments.
     *
     * @param xRapidApiKey key for getting access to rapid api.
     * @param placeSearchDto {@link PlacesPlaceDto} object for search places
     * @return the collection of the {@link PlacesPlaceDto} objects.
     */
    List<PlacesPlaceDto> retrieveListPlaces(String xRapidApiKey, PlaceSearchDto placeSearchDto);
}
