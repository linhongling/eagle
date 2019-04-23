package com.eagle.order.util;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Map;

public class BeanUtil {

    private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    /**
     * bean成员变量与map值对应设值
     * @param claz
     * @param t 成员变量名称的小写必须不一致，否则设置错误
     * @param valueMap
     * @throws
     */
    public static <T> void beanValueUtil(Class<T> claz, T t, Map<String, Object> valueMap){
        Field[] fields = claz.getDeclaredFields();
        for (Field field : fields) {
            Object value = valueMap.get(field.getName().toLowerCase());
            if (value != null) {
                if (value.getClass().getName().equals(Timestamp.class.getName()) && field.getType().getName().equals(java.util.Date.class.getName())) {
                    value = new java.util.Date(((Timestamp)value).getTime());
                }
                try {
                    BeanUtils.setProperty(t, field.getName(), value);
                } catch (Exception e) {
                    logger.error("转换出错：", e);
                    logger.error("value instanceof Timestamp:" + (value.getClass().getName().equals(Timestamp.class.getName())));
                    logger.error("field.getType().equals(java.util.Date.class):" + (field.getType().equals(java.util.Date.class)));
                    logger.error("字段名：" + field.getName() + ",字段类型：" + field.getType().getName() + ",value类型：" + value.getClass().getName()+ "");
                }
            }
        }
    }

}
