package org.example.lab_8;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.OptionalDouble;

@Getter
public class CityYearWeather {
    @Setter
    @JsonIgnoreProperties
    private City city;
    @JsonProperty("daily")
    private YearWeather weather;
    @JsonIgnoreProperties
    private double avgYearTemp = Arrays.stream(weather.getAvgTempByDay()).average().getAsDouble();
    @JsonIgnoreProperties
    private double avgYearPrecipitation = Arrays.stream(weather.getPrecipitationsByDay()).average().getAsDouble();
}
