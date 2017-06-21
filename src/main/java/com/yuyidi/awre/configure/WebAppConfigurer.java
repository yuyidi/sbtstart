package com.yuyidi.awre.configure;

import com.yuyidi.awre.UniversalEnumConverterFactory;
import com.yuyidi.awre.resolver.InterfaceMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
* @author yuyidi 2017-06-15 13:39:39
* @class com.yuyidi.awre.configure.WebAppConfigurer
* @description 自定义MVC配置
*/
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addConverterFactory(new UniversalEnumConverterFactory());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new InterfaceMethodArgumentResolver(false));
    }
}
