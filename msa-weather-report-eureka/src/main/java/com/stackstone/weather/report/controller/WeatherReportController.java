package com.stackstone.weather.report.controller;

import com.stackstone.weather.report.service.WeatherReportService;
import com.stackstone.weather.report.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/1 15:21
 * @since 1.0.0
 */
@RestController
@RequestMapping("/report")
@Slf4j
public class WeatherReportController {

    private final WeatherReportService weatherReportService;

    public WeatherReportController(WeatherReportService weatherReportService) {
        this.weatherReportService = weatherReportService;
    }

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable String cityId, Model model) {
        // TODO 改为由城市数据API微服务来提供数据
        List<City> cityList;
        try {
            // TODO 调用城市数据API
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280601");
            city.setCityName("深圳");
            cityList.add(city);

            city = new City();
            city.setCityId("101280301");
            city.setCityName("惠州");
            cityList.add(city);
        } catch (Exception e) {
            log.error("获取城市信息异常！", e);
            throw new RuntimeException("获取城市信息异常！", e);
        }

        model.addAttribute("title", "StackStone-天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
