package com.yuyidi.awre.resolver;

import com.yuyidi.awre.ApplicationContextBeanFactory;
import com.yuyidi.awre.annotation.Interface;
import com.yuyidi.utils.NormalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuyidi 2017-06-21 16:41:13
 * @class com.yuyidi.awre.resolver.InterfaceMethodArgumentResolver
 * @description 解析接口类型参数
 */
public class InterfaceMethodArgumentResolver extends ModelAttributeMethodProcessor implements
        HandlerMethodArgumentResolver {

    private final Map<Class, Field[]> realizeFieldCache =
            new ConcurrentHashMap<>(256);
    Logger logger = LoggerFactory.getLogger(InterfaceMethodArgumentResolver.class);
    private Map<Class, List<Object>> realizeMap;

    public InterfaceMethodArgumentResolver(boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Interface.class);
    }

    @Override
    protected Object createAttribute(String attributeName, MethodParameter methodParam, WebDataBinderFactory
            binderFactory, NativeWebRequest webRequest) throws Exception {
        Class clazz = methodParam.getParameterType();
        //获取参数类型并根据参数类型获取具体的实现类
        if (realizeMap == null)
            realizeMap = ApplicationContextBeanFactory.getInterfaceRealize();
        List<Object> realizes = realizeMap.get(clazz);
        for (Object obj : realizes) {
            Class realize = obj.getClass();
            //若当前类为实现类 获取当前类的属性信息
            Field[] fields = realizeFieldCache.get(realize);
            if (fields == null) {
                fields = NormalUtil.fields(realize);
                this.realizeFieldCache.put(clazz, fields);
            }
            HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
            MutablePropertyValues mpvs = new ServletRequestParameterPropertyValues(request);
            List<PropertyValue> propertyValues = mpvs.getPropertyValueList();
            //匹配度值
            int matching = 0;
            Map<String, Object> propertyMap = new HashMap<>();
            for (PropertyValue propertyValue : propertyValues) {
                //遍历参数 与 当前的属性名称对比
                propertyMap.put(propertyValue.getName(), propertyValue.getValue());
            }
            for (Field field : fields) {
                if (propertyMap.containsKey(field.getName()))
                    matching++;
                if (matching == propertyValues.size())
                    //若当前参数在当前对象实例中都能找到对应的属性 则表示匹配成功
                    return realize.newInstance();
            }
        }
        return null;
    }

    @Override
    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
        ServletRequest servletRequest = request.getNativeRequest(ServletRequest.class);
        ServletRequestDataBinder servletBinder = (ServletRequestDataBinder) binder;
        servletBinder.bind(servletRequest);
    }


}
