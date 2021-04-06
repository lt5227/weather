package com.stackstone.weather.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 * 
 * @author LiLei
 * @version 1.0.0
 * @date 2021-03-19 02:03:05
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WeatherCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCollectionApplication.class, args);
    }

}
