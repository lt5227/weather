package com.stackstone.weather.service;

import com.stackstone.weather.vo.Weather;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /3/22 16:09
 * @since 1.0.0
 */
public interface WeatherReportService {
    /**
     * 根据城市ID查询天气信息
     *
     * @param cityId the city id
     * @return data by city id
     */
    Weather getDataByCityId(String cityId);
}
