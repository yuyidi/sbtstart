package com.yuyidi.awre;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
* @author yuyidi 2017-06-26 17:28:01
* @class com.yuyidi.awre.JpaConfig
* @description 声明jpa的配置
*/
@EnableJpaRepositories(basePackages = {"com.yuyidi.dao"},
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Repository.class),
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class),
                          @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                          @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class)},
        repositoryImplementationPostfix = "Impl",
        namedQueriesLocation = "META-INF/jpa-named-queries.properties",
        queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
public class JpaConfig {}
