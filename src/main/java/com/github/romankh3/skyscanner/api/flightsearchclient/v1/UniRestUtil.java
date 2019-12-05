package com.github.romankh3.skyscanner.api.flightsearchclient.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.exception.FlightSearchApiClientException;
import com.github.romankh3.skyscanner.api.flightsearchclient.v1.model.validation.ValidationErrorsDto;
import java.util.List;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

/**
 * Unit with static methods for using Unirest library.
 *
 * @author Roman Beskrovnyi
 * @since 0.1
 */
final class UniRestUtil {

    private static final String HOST = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

    static final String PLACES_FORMAT = "/apiservices/autosuggest/v1.0/%s/%s/%s/?query=%s";
    static final String CURRENCIES_FORMAT = "/apiservices/reference/v1.0/currencies";
    static final String COUNTRIES_FORMAT = "/apiservices/reference/v1.0/countries/%s";
    static final String VALIDATIONS_KEY = "ValidationErrors";

    static final String PLACES_KEY = "Places";
    static final String CURRENCIES_KEY = "Currencies";
    static final String COUNTRIES_KEY = "Countries";

    private static ObjectMapper objectMapper = new ObjectMapper();


    public static HttpResponse<JsonNode> get(String xRapidApiKey, String path) {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://" + HOST + path)
                    .header("x-rapidapi-host", HOST)
                    .header("x-rapidapi-key", xRapidApiKey)
                    .asJson();

            if (response.getStatus() != HttpStatus.SC_OK) {
                throw new FlightSearchApiClientException(
                        String.format("There are validation errors. statusCode = %s", response.getStatus()),
                        readValueWrapper(response.getBody().getObject().get(VALIDATIONS_KEY).toString(),
                                new TypeReference<List<ValidationErrorsDto>>() {
                                }));
            }
        } catch (UnirestException e) {
            throw new FlightSearchApiClientException(String.format("Request failed, path=%s", HOST + path), e);
        }

        return response;
    }

    static <T> T readValueWrapper(String content, TypeReference<T> valueTypeRef) {
        try {
            return objectMapper.readValue(content, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new FlightSearchApiClientException("Object Mapping failure.", e);
        }
    }
}
