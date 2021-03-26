package com.stackstone.weather.collection.job;

import com.stackstone.weather.collection.service.WeatherDataCollectionService;
import com.stackstone.weather.collection.vo.City;
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

    private final WeatherDataCollectionService weatherDataCollectionService;

    public WeatherDataSyncJob(WeatherDataCollectionService weatherDataCollectionService) {
        this.weatherDataCollectionService = weatherDataCollectionService;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("Start 天气数据同步任务");
        // TODO 改为由城市数据API微服务来提供数据
        List<City> cityList = null;
        try {
            // TODO 调用城市数据API
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280601");
            cityList.add(city);
        } catch (Exception e) {
            log.error("获取城市信息异常!", e);
            throw new RuntimeException("获取城市信息异常!", e);
        }

        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("天气数据同步任务中, cityId:{}", cityId);
            // 根据城市ID同步天气数据
            weatherDataCollectionService.syncDataByCityId(cityId);
        }
        log.info("End 天气数据同步任务");
    }
}
