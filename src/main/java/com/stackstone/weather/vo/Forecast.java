package com.stackstone.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 未来天气信息类
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/3/19 14:16
 * @since 1.0.0
 */
@Data
public class Forecast implements Serializable {

    private static final long serialVersionUID = 1121521936542383356L;

    /**
     * 日期
     */
    private String date;

    /**
     * 最高温度
     */
    private String high;

    /**
     * 最低温度
     */
    private String low;

    /**
     * 风向
     */
    private String fengxiang;

    /**
     * 风力
     */
    private String fengli;

    /**
     * 天气类型
     */
    private String type;
}
