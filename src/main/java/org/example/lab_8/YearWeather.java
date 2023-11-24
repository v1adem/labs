package org.example.lab_8;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;
@Getter
public class YearWeather {
    @JsonProperty("time")
    private Date[] dates;
    @JsonProperty("temperature_2m_mean")
    private double[] AvgTempByDay;
    @JsonProperty("precipitation_sum")
    private double[] PrecipitationsByDay;
}
