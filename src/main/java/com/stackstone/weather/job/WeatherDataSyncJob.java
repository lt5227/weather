package com.stackstone.weather.job;

import com.stackstone.weather.service.CityDataService;
import com.stackstone.weather.service.WeatherDataService;
import com.stackstone.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气数据同步任务
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/3/19 17:22
 * @since 1.0.0
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    private final CityDataService cityDataService;

    private final WeatherDataService weatherDataService;

    public WeatherDataSyncJob(CityDataService cityDataService, WeatherDataService weatherDataService) {
        this.cityDataService = cityDataService;
        this.weatherDataService = weatherDataService;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("Start 天气数据同步任务");
        // 读取城市列表
        List<City> cityList = new ArrayList<>();
        try {
            cityList.addAll(cityDataService.listCity());
        } catch (Exception e) {
            log.error("获取城市信息异常!", e);
        }
        cityList.forEach(city -> {
            String cityId = city.getCityId();
            log.info("天气数据同步任务中, city：{}", cityId);
            // 根据城市ID获取天气
            weatherDataService.syncDataByCityId(cityId);
        });
        log.info("End 天气数据同步任务");
    }
}
