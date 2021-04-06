package com.stackstone.weahter.eureka.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/6 14:22
 * @since 1.0.0
 */
@FeignClient("msa-weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    String listCity();
}
