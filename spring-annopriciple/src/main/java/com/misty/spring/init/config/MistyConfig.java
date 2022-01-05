package com.misty.spring.init.config;

import com.misty.spring.init.compent.Car;
import com.misty.spring.init.compent.Cat;
import com.misty.spring.init.compent.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MistyConfig
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 14:24
 * @Version 1.0
 **/
@Configuration
@ComponentScan(basePackages = "com.misty.spring.init.compent")
public class MistyConfig {

    @Bean(initMethod = "initMethod",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }

    @Bean
    public Person person(){
        return new Person();
    }

    @Bean
    public Cat cat(){
        return new Cat();
    }

}
