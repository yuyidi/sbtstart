package com.yuyidi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Hello world!
 */
@SpringBootApplication
public class ApplicationBootstart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootstart.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args ->{
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
        };
    }
}
