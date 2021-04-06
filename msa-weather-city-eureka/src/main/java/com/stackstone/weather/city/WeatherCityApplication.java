package com.stackstone.weather.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/1 15:45
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WeatherCityApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherCityApplication.class, args);
    }
}
