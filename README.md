# skyscanner-flight-api-client
 [![Maven Central](https://img.shields.io/maven-central/v/com.github.romankh3/skyscanner-flight-api-client.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.romankh3%22%20AND%20a:%22skyscanner-flight-api-client%22)
 [ ![jCenter](https://api.bintray.com/packages/romankh3/maven/skyscanner-flight-api-client/images/download.svg) ](https://bintray.com/romankh3/maven/skyscanner-flight-api-client/_latestVersion)

## Description
Published on Maven Central and jCenter Client for Skyscanner [Flight Search API](https://english.api.rakuten.net/skyscanner/api/skyscanner-flight-search/) hosted in Rapid Api

**Latest version 0.1.10**

## Release Notes

### 0.1.10
*  provided build.gradle and publish process via bintray-gradle-plugin

### 0.1
*   added Places call
*   added Localisation call
*   added browse quotes for Browse Flight Search

## Plans to add
*   add all the requests for Browse Flight Search
*   add Live Flight Search

## Usage
Skyscanner has four groups of requests and all has public interfaces with implementations for using.
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




