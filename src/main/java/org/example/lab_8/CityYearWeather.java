package org.example.lab_8;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CityYearWeather {
    @Setter
    @JsonIgnoreProperties
    public City city;
    @JsonProperty("daily")
    public YearWeather weather;
}
