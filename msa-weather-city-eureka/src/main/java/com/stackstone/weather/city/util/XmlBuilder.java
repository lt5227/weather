package com.stackstone.weather.city.util;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * XML 工具
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/3/19 18:00
 * @since 1.0.0
 */
@Slf4j
public class XmlBuilder {
    private XmlBuilder() {

    }

    public static <T> T xmlStrToObject(Class<T> clazz, String xmlStr) {
        T xmlObject = null;
        Reader reader;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 将XML转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new StringReader(xmlStr);
            Object o = unmarshaller.unmarshal(reader);
            if (clazz.isInstance(o)) {
                xmlObject = clazz.cast(o);
            }
            reader.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return xmlObject;
    }
}
