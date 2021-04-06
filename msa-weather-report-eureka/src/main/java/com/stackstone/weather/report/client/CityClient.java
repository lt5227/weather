package com.stackstone.weather.report.client;

import com.stackstone.weather.report.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /4/6 14:47
 * @since 1.0.0
 */
@FeignClient("msa-weather-city-eureka")
public interface CityClient {

    /**
     * 获取城市列表
     *
     * @return the list
     */
    @GetMapping("/cities")
    List<City> listCity();
}
