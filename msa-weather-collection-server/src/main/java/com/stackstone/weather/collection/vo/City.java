package com.stackstone.weather.collection.vo;

import lombok.Data;

/**
 * 城市
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/3/19 17:51
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
