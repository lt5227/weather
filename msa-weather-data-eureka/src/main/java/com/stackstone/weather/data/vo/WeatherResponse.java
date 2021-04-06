package com.stackstone.weather.data.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/3/19 14:25
 * @since 1.0.0
 */
@Data
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 6005467240817825514L;

    /**
     * 消息数据
     */
    private Weather data;

    /**
     * 消息状态
     */
    private String status;

    /**
     * 消息描述
     */
    private String desc;
}
