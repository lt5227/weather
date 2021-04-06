package com.stackstone.weather.city.service.impl;

import com.stackstone.weather.city.service.CityDataService;
import com.stackstone.weather.city.util.XmlBuilder;
import com.stackstone.weather.city.vo.City;
import com.stackstone.weather.city.vo.CityList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/1 15:50
 * @since 1.0.0
 */
@Service
@Slf4j
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() {
        // 读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            // XML 转 Java对象
            CityList cityList = XmlBuilder.xmlStrToObject(CityList.class, builder.toString());
            return cityList.getCities();
        } catch (IOException e) {
            log.error("获取城市列表失败", e);
        }
        return Collections.emptyList();
    }
}
