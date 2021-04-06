package com.stackstone.weather.city.controller;

import com.stackstone.weather.city.service.CityDataService;
import com.stackstone.weather.city.vo.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/6 10:17
 * @since 1.0.0
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityDataService cityDataService;

    public CityController(CityDataService cityDataService) {
        this.cityDataService = cityDataService;
    }

    @GetMapping
    public List<City> listCity() {
        return cityDataService.listCity();
    }
}
