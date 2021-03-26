package com.stackstone.weather.collection.service;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /3/25 17:18
 * @since 1.0.0
 */
public interface WeatherDataCollectionService {
    /**
     * 根据城市ID同步天气数据
     *
     * @param cityId the city id
     */
    void syncDataByCityId(String cityId);
}
