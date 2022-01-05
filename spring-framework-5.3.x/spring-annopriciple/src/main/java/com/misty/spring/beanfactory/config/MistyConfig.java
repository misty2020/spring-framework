package com.misty.spring.beanfactory.config;

import com.misty.spring.beanfactory.compent.CarFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName MistyConfig
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 10:12
 * @Version 1.0
 **/
@Configuration
@ImportResource(locations = {"classpath:beans.xml"})
public class MistyConfig {
    @Bean
    public CarFactoryBean carFactoryBean(){
        return new CarFactoryBean();
    }
}
