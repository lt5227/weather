package com.stackstone.weather.data.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackstone.weather.data.service.WeatherDataService;
import com.stackstone.weather.data.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

    private final StringRedisTemplate stringRedisTemplate;

    private static final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    public WeatherDataServiceImpl(StringRedisTemplate stringRedisTemplate) {
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

    private WeatherResponse doGetWeatherData(String uri) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String strBody;
        if (Boolean.FALSE.equals(this.stringRedisTemplate.hasKey(uri))) {
            log.error("不存在 key: {}", uri);
            throw new RuntimeException("没有相应的天气信息");
        } else {
            strBody = ops.get(uri);
            log.info("找到 key: {}, value = {}", uri, strBody);
        }
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather;
        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.error("JSON反序列化异常!", e);
            throw new RuntimeException("天气信息解析失败");
        }
        return weather;
    }
}
