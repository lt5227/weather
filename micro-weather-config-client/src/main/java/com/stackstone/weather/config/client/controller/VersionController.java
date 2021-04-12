package com.stackstone.weather.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/12 16:10
 * @since 1.0.0
 */
@RefreshScope
@RestController
public class VersionController {

    @Value("${auther}")
    private String auther;

    @Value("${version}")
    private String version;

    @RequestMapping("/config")
    public String getConfig() {
        return auther + " " + version;
    }
}
