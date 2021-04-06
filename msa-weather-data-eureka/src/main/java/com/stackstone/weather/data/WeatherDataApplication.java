package com.stackstone.weather.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021 /3/26 16:27
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WeatherDataApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WeatherDataApplication.class, args);
    }
}
