package com.stackstone.weather.data.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/3/19 14:22
 * @since 1.0.0
 */
@Data
public class Weather implements Serializable {
    private static final long serialVersionUID = -544952932166850093L;

    /**
     * 城市
     */
    private String city;

    /**
     * 空气指数
     */
    private String aqi;

    /**
     * 实时温度
     */
    private String wendu;

    /**
     * 感冒信息提示
     */
    private String ganmao;

    /**
     * 昨日天气
     */
    private Yesterday yesterday;

    /**
     * 未来天气
     */
    private List<Forecast> forecast;
}
