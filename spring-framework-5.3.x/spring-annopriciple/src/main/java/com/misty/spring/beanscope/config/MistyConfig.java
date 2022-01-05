package com.misty.spring.beanscope.config;

import com.misty.spring.beanscope.compent.Car;
import com.misty.spring.beanscope.compent.Person;
import com.misty.spring.beanscope.compent.Zoo;
import org.springframework.context.annotation.*;

/**
 * @ClassName MainConfig
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/27 16:59
 * @Version 1.0
 **/
@Configuration
public class MistyConfig {

    @Bean
    public Person person(){
        System.out.println("默认的单例模式 饿汉式加载");
        return new Person();
    }

    @Bean
    @Scope(scopeName = "prototype")
    public Car car(){
        System.out.println("多例模式  懒汉式加载 调用时才会创建对象 不被三级缓存管理");
        return new Car();
    }

    @Bean
    @Lazy
    public Zoo zoo(){
        System.out.println("懒加载模式");
        return new Zoo();
    }
}
