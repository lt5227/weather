package com.stackstone.weahter.eureka.client.controller;

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

    public CityController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/cities")
    public String listCity() {
        String body = restTemplate
                .getForEntity("http://msa-weather-city-eureka/cities", String.class)
                .getBody();
        return body;
    }
}
