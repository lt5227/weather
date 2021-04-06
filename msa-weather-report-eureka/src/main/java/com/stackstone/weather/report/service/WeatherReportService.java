package com.stackstone.weather.report.service;

import com.stackstone.weather.report.vo.Weather;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /4/1 15:11
 * @since 1.0.0
 */
public interface WeatherReportService {
    /**
     * 根据城市ID查询天气信息
     *
     * @param cityId 城市ID
     * @return data by city id
     */
    Weather getDataByCityId(String cityId);
}
