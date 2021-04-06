package com.stackstone.weather.report.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 昨日天气信息类
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/3/19 14:19
 * @since 1.0.0
 */
@Data
public class Yesterday implements Serializable {
    private static final long serialVersionUID = -8330746117335931002L;

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
    private String fx;

    /**
     * 风力
     */
    private String fl;

    /**
     * 天气类型
     */
    private String type;
}
