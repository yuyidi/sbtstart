package com.yuyidi.awre;

import com.yuyidi.awre.annotation.Interface;
import com.yuyidi.awre.annotation.Realize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by yuyidi on 2017/6/19.
 * @desc
 */
@Component
public class ApplicationContextBeanFactory implements ApplicationContextAware {

    private static Map<Class, List<Object>> interfaceRealize;
    Logger logger = LoggerFactory.getLogger(getClass());

    public static Map<Class, List<Object>> getInterfaceRealize() {
        return interfaceRealize;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 找到需要的注解实现类
        Map<String, Object> realizesMap = applicationContext.getBeansWithAnnotation(Realize.class);
        interfaceRealize = new HashMap<>();
        //找到实现类的接口
        for (Map.Entry<String, Object> entry : realizesMap.entrySet()) {
            Object realize = entry.getValue();
            //获取相应的实现类找到实现类的第一个接口，后期再找有没有更好的解决办法
            Class interfaces = realize.getClass().getInterfaces()[0];
            if (interfaces.getAnnotation(Interface.class) != null) {
                //若获取接口的注解为Inteface  则表明获取到
                List<Object> realizeList = null;
                if (!interfaceRealize.containsKey(interfaces)) {
                    realizeList = new ArrayList<>();
                }else{
                    realizeList = interfaceRealize.get(interfaces);
                }
                realizeList.add(realize);
                interfaceRealize.put(interfaces,realizeList);
            }
        }

        for (Map.Entry<Class, List<Object>> entry : interfaceRealize.entrySet()) {
            logger.info("接口名称：{}",entry.getKey().getName());
            for (Object obj : entry.getValue()){
                logger.info("实现类名称:{}",obj.getClass().getName());
            }
        }
    }
}
