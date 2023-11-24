package org.example.lab_8;

import java.io.IOException;
import java.util.List;

public class WeatherApiDemo {
    private static final String[] cityNames = new String[] {
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

    public static void main(String[] args) {
        cities.forEach(city -> {
            try {
                var yearWeather = WeatherApiClient.getYearWeather(city).getWeather();
                for (int i = 0; i < yearWeather.getDates().length; i++) {
                    System.out.println(yearWeather.getDates()[i] + "|" + yearWeather.getAvgTempByDay()[i] + "|" + yearWeather.getPrecipitationsByDay()[i] + "\n");
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
