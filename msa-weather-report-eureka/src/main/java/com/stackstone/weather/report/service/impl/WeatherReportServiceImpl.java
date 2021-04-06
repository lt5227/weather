package com.stackstone.weather.report.service.impl;

import com.stackstone.weather.report.client.WeatherDataClient;
import com.stackstone.weather.report.service.WeatherReportService;
import com.stackstone.weather.report.vo.Weather;
import com.stackstone.weather.report.vo.WeatherResponse;
import org.springframework.stereotype.Service;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/1 15:11
 * @since 1.0.0
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    private final WeatherDataClient weatherDataClient;

    public WeatherReportServiceImpl(WeatherDataClient weatherDataClient) {
        this.weatherDataClient = weatherDataClient;
    }

    @Override
    public Weather getDataByCityId(String cityId) {
        // 由天气数据API微服务来提供数据
        WeatherResponse response = weatherDataClient.getDataByCityId(cityId);
        return response.getData();
    }
}
