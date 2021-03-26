package com.stackstone.weather.collection.service.impl;

import com.stackstone.weather.collection.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /3/25 17:19
 * @since 1.0.0
 */
@Service
@Slf4j
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private final RestTemplate restTemplate;
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 天气API地址
     */
    private static final String WEATHER_API = "http://wthrcdn.etouch.cn/weathermini";

    /**
     * 缓存超时时间
     */
    private static final Long TIME_OUT = 1800L;


    /**
     * Instantiates a new Weather data collection service.
     *
     * @param restTemplate        the rest template
     * @param stringRedisTemplate the string redis template
     */
    public WeatherDataCollectionServiceImpl(RestTemplate restTemplate,
                                            StringRedisTemplate stringRedisTemplate) {
        this.restTemplate = restTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void syncDataByCityId(String cityId) {
        log.info("Start 同步天气 cityId:{}", cityId);
        String uri = WEATHER_API + "?citykey=" + cityId;
        this.saveWeatherData(uri);
        log.info("End 同步天气");
    }

    private void saveWeatherData(String uri) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String strBody = null;
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        int statusCode = 200;
        if (response.getStatusCodeValue() == statusCode) {
            strBody = response.getBody();
        }
        if (strBody != null) {
            ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
        }
    }
}
