package com.yuyidi.utils;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author Created by yuyidi on 2017/6/21.
 * @desc
 */
public class NormalUtil {


    /**
     * @param clazz
     * @return java.lang.reflect.Field[]
     * @author yuyidi 2017-06-21 16:43:47
     * @method fields
     * @description 递归循环获取类的属性
     */
    public static Field[] fields(Class clazz) {
        Field[] result = clazz.getDeclaredFields();
        if (clazz.getSuperclass() == Object.class) {
            return result;
        } else {
            return concat(fields(clazz.getSuperclass()), result);
        }
    }

    /**
     * @param first
     * @param second
     * @return T[]
     * @author yuyidi 2017-06-21 16:44:15
     * @method concat
     * @description 追加数组
     */
    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
