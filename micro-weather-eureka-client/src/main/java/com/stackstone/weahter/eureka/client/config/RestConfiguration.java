package com.stackstone.weahter.eureka.client.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/6 13:52
 * @since 1.0.0
 */
@Configuration
@RibbonClient(name = "ribbon-client", configuration = RibbonConfiguration.class)
public class RestConfiguration {

    private final RestTemplateBuilder builder;

    public RestConfiguration(RestTemplateBuilder builder) {
        this.builder = builder;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return builder.build();
    }
}
