package org.example.lab_8;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherApiClient {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static List<City> getCoordinates(String... cityNames){
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<City> cities = new ArrayList<>();
        Arrays.stream(cityNames).forEach(cityName -> {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI("https://geocoding-api.open-meteo.com/v1/search?name="
                                + cityName + "&count=10&language=en&format=json"))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                cities.add(mapper.readValue(response.body(), CitySearchResult.class).getResults()[0]);

            } catch (URISyntaxException | IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return cities;
    }

    public static CityYearWeather getYearWeather(@NotNull City city) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://archive-api.open-meteo.com/v1/archive?" +
                "latitude=" + city.getLatitude() +
                "&longitude=" + city.getLongitude() +
                "&start_date=2022-10-31" +
                "&end_date=2023-11-01" +
                "&daily=temperature_2m_mean,precipitation_sum")).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        CityYearWeather result = mapper.readValue(response.body(), CityYearWeather.class);
        result.setCity(city);
        return result;
    }
}
