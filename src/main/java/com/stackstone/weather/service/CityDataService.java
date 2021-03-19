package com.stackstone.weather.service;

import com.stackstone.weather.vo.City;

import java.util.List;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /3/19 18:13
 * @since 1.0.0
 */
public interface CityDataService {

    /**
     * 获取城市列表
     *
     * @return the list
     */
    List<City> listCity();
}
