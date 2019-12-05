package com.github.romankh3.skyscanner.api.flightsearchclient.v1;

import static com.github.romankh3.skyscanner.api.flightsearchclient.v1.TestUtil.xRapidApiKey;

import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.localisation.CountryDto;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.localisation.CurrencyDto;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test for {@link LocalisationClient} object.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocalisationClientTest {

    private final LocalisationClient client = new LocalisationClientImpl();

    @Test
    public void shouldReturnLocalisationCurrencies() {
        List<CurrencyDto> currencyDtos = client.retrieveCurrencies(xRapidApiKey);
        Assert.assertFalse(currencyDtos.isEmpty());
    }

    @Test
    public void shouldReturnLocalisationCountries() {
        List<CountryDto> countryDtos = client.retrieveCountries("ru-RU", xRapidApiKey);
        Assert.assertFalse(countryDtos.isEmpty());
    }
}
