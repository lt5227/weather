package com.stackstone.weather.report.vo;

import lombok.Data;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/1 15:25
 * @since 1.0.0
 */
@Data
public class City {

    /**
     * 城市ID
     */
    private String cityId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 省份
     */
    private String province;
}
