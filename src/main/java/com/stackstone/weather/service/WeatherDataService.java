package com.stackstone.weather.service;

import com.stackstone.weather.vo.WeatherResponse;

/**
 * 天气数据服务
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /3/19 14:27
 * @since 1.0.0
 */
public interface WeatherDataService {
    /**
     * 根据城市ID来查询天气数据
     *
     * @param cityId the city id
     * @return data by city id
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称来查询天气数据
     *
     * @param cityName the city name
     * @return data by city name
     */
    WeatherResponse getDataByCityName(String cityName);
}
