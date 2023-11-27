package org.example.lab_8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherApiDemo {
    private static final String[] cityNames = new String[]{
            "Kyiv",
            "Lviv",
            "London",
            "Bristol",
            "Washington",
            "Paris",
            "Ottawa",
            "Bila",
            "Warsaw",
            "Osaka",
            "Tokyo",
            "Viena",
            "Kyoto",
            "Odesa",
            "Rome",
            "Berlin",
            "Riga",
            "Sofia",
            "NewYork",
            "Vyshneve"
    };

    private static final List<City> cities = WeatherApiClient.getCoordinates(cityNames);
    private static final List<CityYearWeather> citiesYearWeather = new ArrayList<>();

    public static void main(String[] args) {
        cities.forEach(city -> {
            try {
                CityYearWeather yearWeather = WeatherApiClient.getCityYearWeather(city);
                citiesYearWeather.add(yearWeather);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        WeatherAnalyzer.getColdestCities(citiesYearWeather);
    }
}
