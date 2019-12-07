# skyscanner-flight-api-client

## Description
This is client for Skyscanner [Flight Search API](https://english.api.rakuten.net/skyscanner/api/skyscanner-flight-search/) hosted in Rapid Api

## Release Notes

### 0.1
*   added Places call
*   added Localisation call
*   added browse quotes for Browse Flight Search

## Plans to add
*   add all the requests for Browse Flight Search
*   add Live Flight Search

## Usage
Skyscanner has four groups of requests and all has public interfaces with implementations for using.
*   Live Flight Search(to be added) -> LiveFlightSearchClient ^ LiveFlightSearchClientImpl
*   Places(added) -> PlacesClient ^ PlacesClientImpl
*   Browse Flight Prices(added one request) -> BrowseFlightPricesClient -> BrowseFlightPricesClientImpl
*   Localisation(added) -> LocalisationClient ^ LocalisationClientImpl

For example LocalisationClient:
```
String xRapidApiKey = YOUR-API-KEY;
LocalisationClient client = new LocalisationClientImpl();

List<CurrencyDto> currencyDtos = client.retrieveCurrencies(xRapidApiKey);

// or
String locale = "ru-RU";
List<CountryDto> countryDtos = client.retrieveCountries(locale, xRapidApiKey);
```




