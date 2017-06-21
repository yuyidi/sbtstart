package com.yuyidi.awre;

import com.yuyidi.business.CommonalityEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Created by yuyidi on 2017/6/15.
 * @desc
 */
public class UniversalEnumConverterFactory implements ConverterFactory<String, CommonalityEnum> {

    public static final Map<Class, Converter> converterMap = new WeakHashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <T extends CommonalityEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter result = converterMap.get(targetType);
        if (result == null) {
            result = new IntegerStrToEnum<>(targetType);
            converterMap.put(targetType, result);
        }
        return result;
    }

    class IntegerStrToEnum<T extends CommonalityEnum> implements Converter<String, T> {
        private final Class<T> enumType;
        private Map<String, T> enumMap = new HashMap<>();

        public IntegerStrToEnum(Class<T> enumType) {
            this.enumType = enumType;
            T[] enums = enumType.getEnumConstants();
            for (T e : enums) {
                enumMap.put(e.getIndex() + "", e);
            }
        }


        @Override
        public T convert(String source) {
            T result = enumMap.get(source);
            if (result == null) {
                throw new IllegalArgumentException("No element matches " + source);
            }
            return result;
        }
    }
}
