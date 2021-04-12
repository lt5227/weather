package com.stackstone.weahter.eureka.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stackstone.weahter.eureka.client.service.CityClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/6 13:56
 * @since 1.0.0
 */
@RestController
public class CityController {

    private final RestTemplate restTemplate;

    private final CityClient cityClient;

    public CityController(RestTemplate restTemplate, CityClient cityClient) {
        this.restTemplate = restTemplate;
        this.cityClient = cityClient;
    }

    @GetMapping("/cities1")
    public String listCity1() {
        return restTemplate
                .getForEntity("http://msa-weather-city-eureka/cities", String.class)
                .getBody();
    }

    @GetMapping("/cities2")
    @HystrixCommand(fallbackMethod = "defaultCities")
    public String listCity2() {
        return cityClient.listCity();
    }

    public String defaultCities() {
        return "城市数据API服务暂时不可用!";
    }
}
