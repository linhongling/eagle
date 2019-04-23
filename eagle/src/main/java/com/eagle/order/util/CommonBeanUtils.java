package com.eagle.order.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 复制对象
 *
 * @author gs
 */
public class CommonBeanUtils extends BeanUtils {


    /**
     * Copy list list.
     *
     * @param <F>      the type parameter
     * @param <T>      the type parameter
     * @param fromList the from list
     * @param toClazz  the to clazz
     * @return the list
     */
    public static<F,T> List<T> copyList(List<F> fromList, Class<T> toClazz){
        if(fromList == null){
            return null;
        }
        List<T> toList = new ArrayList<>(fromList.size());
        Object object = null;

        for (F f:fromList){
            try {
                object = toClazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(f,object);
            toList.add((T)object);
        }
        return toList;
    }
}
