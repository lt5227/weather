package com.stackstone.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackstone.weather.service.WeatherDataService;
import com.stackstone.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /3/19 14:29
 * @since 1.0.0
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {

    /**
     * 天气预报API地址
     */
    private static final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    /**
     * 缓存超时时间
     */
    private static final long TIME_OUT = 1800L;

    private final RestTemplate restTemplate;

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * Instantiates a new Weather data service.
     *
     * @param restTemplate        the rest template
     * @param stringRedisTemplate the string redis template
     */
    public WeatherDataServiceImpl(RestTemplate restTemplate,
                                  StringRedisTemplate stringRedisTemplate) {
        this.restTemplate = restTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_API + "?citykey=" + cityId;
        return this.doGetWeatherData(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_API + "?city=" + cityName;
        return this.doGetWeatherData(uri);
    }

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_API + "?citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    private void saveWeatherData(String uri) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String strBody = null;
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        int successStatusCode = 200;
        if (response.getStatusCodeValue() == successStatusCode) {
            strBody = response.getBody();
        }
        if (strBody != null) {
            ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
        }
    }

    private WeatherResponse doGetWeatherData(String uri) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        // 将调用的URI作为缓存的Key
        String strBody = null;
        if (Boolean.FALSE.equals(this.stringRedisTemplate.hasKey(uri))) {
            log.info("未找到 key : {}", uri);
            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            int successStatusCode = 200;
            if (response.getStatusCodeValue() == successStatusCode) {
                strBody = response.getBody();
            }
            if (strBody != null) {
                ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
            }
        } else {
            strBody = ops.get(uri);
            log.info("找到 key: {}, value = {}", uri, strBody);
        }
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return weather;
    }
}
