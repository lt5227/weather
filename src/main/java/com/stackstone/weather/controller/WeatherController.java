package com.stackstone.weather.controller;

import com.stackstone.weather.service.WeatherDataService;
import com.stackstone.weather.vo.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /3/19 14:52
 * @since 1.0.0
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherDataService weatherDataService;

    /**
     * Instantiates a new Weather controller.
     *
     * @param weatherDataService the weather data service
     */
    public WeatherController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    /**
     * Gets report by city id.
     *
     * @param cityId the city id
     * @return the report by city id
     */
    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getReportByCityId(@PathVariable String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    /**
     * Gets report by city name.
     *
     * @param cityName the city name
     * @return the report by city name
     */
    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getReportByCityName(@PathVariable String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}
