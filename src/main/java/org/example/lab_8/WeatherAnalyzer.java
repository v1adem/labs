package org.example.lab_8;

import java.util.ArrayList;
import java.util.List;

public class WeatherAnalyzer {
    public static List<CityYearWeather> getColdestCities(List<CityYearWeather> citiesYearWeather){
        List<CityYearWeather> coldestCities = new ArrayList<>();
        for (int i = 0; i < citiesYearWeather.size()-1; i++) {
            for (int j = 0; j < citiesYearWeather.size() -i -1; i++){
                if(citiesYearWeather.get(j).getAvgYearTemp() < citiesYearWeather.get(j+1).getAvgYearTemp()){
                    var temp = citiesYearWeather.get(i);
                    //citiesYearWeather.set(citiesYearWeather.get(j));
                }
            }
        }
        return coldestCities;
    }
}
