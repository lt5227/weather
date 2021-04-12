package com.stackstone.weather.report.client;

import com.stackstone.weather.report.client.fallback.DataClientFallback;
import com.stackstone.weather.report.vo.City;
import com.stackstone.weather.report.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /4/6 16:06
 * @since 1.0.0
 */
@FeignClient(value = "msa-weather-eureka-client-zuul", fallback = DataClientFallback.class)
public interface DataClient {

    /**
     * 获取城市列表
     *
     * @return list list
     */
    @GetMapping("/city/cities")
    List<City> listCity();

    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId 城市ID
     * @return data by city id
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
