package com.stackstone.weather.controller;

import com.stackstone.weather.service.CityDataService;
import com.stackstone.weather.service.WeatherReportService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /3/22 16:13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {


    private final CityDataService cityDataService;
    private final WeatherReportService weatherReportService;

    /**
     * Instantiates a new Weather report controller.
     *
     * @param cityDataService      the city data service
     * @param weatherReportService the weather report service
     */
    public WeatherReportController(CityDataService cityDataService,
                                   WeatherReportService weatherReportService) {
        this.cityDataService = cityDataService;
        this.weatherReportService = weatherReportService;
    }

    /**
     * Gets report by city id.
     *
     * @param cityId the city id
     * @param model  the model
     * @return the report by city id
     */
    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable String cityId, Model model) {
        model.addAttribute("title", "StackStone-天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
