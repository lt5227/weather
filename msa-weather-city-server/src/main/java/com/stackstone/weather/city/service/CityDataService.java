package com.stackstone.weather.city.service;

import com.stackstone.weather.city.vo.City;

import java.util.List;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /4/1 15:50
 * @since 1.0.0
 */
public interface CityDataService {

    /**
     * 获取城市列表
     *
     * @return list
     */
    List<City> listCity();
}
