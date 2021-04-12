package com.stackstone.weather.report.client.fallback;

import com.stackstone.weather.report.client.DataClient;
import com.stackstone.weather.report.vo.City;
import com.stackstone.weather.report.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/12 15:11
 * @since 1.0.0
 */
@Component
public class DataClientFallback implements DataClient {
    @Override
    public List<City> listCity() {
        List<City> cityList;
        cityList = new ArrayList<>();
        City city = new City();
        city.setCityId("101280601");
        city.setCityName("深圳");
        cityList.add(city);

        city = new City();
        city.setCityId("101280301");
        city.setCityName("惠州");
        cityList.add(city);
        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return new WeatherResponse();
    }
}
