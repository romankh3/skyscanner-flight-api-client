package com.github.romankh3.skyscanner.api.flightsearchclient.v1;

import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.TestUtil.xRapidApiKey;

import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.place.PlaceSearchDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.place.PlacesPlaceDto;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test for {@link PlacesClient} object.
 */
@RunWith(MockitoJUnitRunner.class)
public class PlacesClientTest {

    private PlacesClient placesClient = new PlacesClientImpl();

    @Test
    public void shouldReturnPlaces() {
        PlaceSearchDto placeSearchDto = PlaceSearchDto.builder()
                .country("UA")
                .currency("UAH")
                .placeName("Kharkiv")
                .locale("ru-RU")
                .build();

        List<PlacesPlaceDto> placesPlaceDtos = placesClient.retrieveListPlaces(xRapidApiKey, placeSearchDto);

        Assert.assertFalse(placesPlaceDtos.isEmpty());
        Assert.assertEquals(1, placesPlaceDtos.size());
        Assert.assertEquals(placeSearchDto.getPlaceName(), placesPlaceDtos.get(0).getPlaceName());
    }
}