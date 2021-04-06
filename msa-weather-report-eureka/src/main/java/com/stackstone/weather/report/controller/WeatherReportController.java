package com.stackstone.weather.report.controller;

import com.stackstone.weather.report.client.CityClient;
import com.stackstone.weather.report.service.WeatherReportService;
import com.stackstone.weather.report.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    private final CityClient cityClient;

    public WeatherReportController(WeatherReportService weatherReportService,
                                   CityClient cityClient) {
        this.weatherReportService = weatherReportService;
        this.cityClient = cityClient;
    }

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable String cityId, Model model) {
        // 由城市数据API微服务来提供数据
        List<City> cityList;
        try {
            // 调用城市数据API
            cityList = cityClient.listCity();
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
