package com.stackstone.weather.service.impl;

import com.stackstone.weather.service.WeatherDataService;
import com.stackstone.weather.service.WeatherReportService;
import com.stackstone.weather.vo.Weather;
import com.stackstone.weather.vo.WeatherResponse;
import org.springframework.stereotype.Service;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /3/22 16:10
 * @since 1.0.0
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    private final WeatherDataService weatherDataService;

    /**
     * Instantiates a new Weather report service.
     *
     * @param weatherDataService the weather data service
     */
    public WeatherReportServiceImpl(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }


    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse result = weatherDataService.getDataByCityId(cityId);
        return result.getData();
    }
}
