package com.stackstone.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 城市
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/3/19 17:51
 * @since 1.0.0
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class City {
    /**
     * 城市ID
     */
    @XmlAttribute(name = "d1")
    private String cityId;

    /**
     * 城市名称
     */
    @XmlAttribute(name = "d2")
    private String cityName;

    /**
     * 城市编码
     */
    @XmlAttribute(name = "d3")
    private String cityCode;

    /**
     * 省份
     */
    @XmlAttribute(name = "d4")
    private String province;
}
