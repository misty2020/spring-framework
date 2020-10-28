package com.misty.spring.beanscope;

import com.misty.spring.beanscope.config.MistyConfig;
import com.misty.spring.beanscope.compent.Car;
import com.misty.spring.beanscope.compent.Person;
import com.misty.spring.beanscope.compent.Zoo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MistyTest
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/16 15:57
 * @Version 1.0
 **/
public class MistyTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MistyConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanName为："+beanDefinitionName);
        }
        Person person = ac.getBean(Person.class);
        Person person1 = ac.getBean(Person.class);
        System.out.println(person==person1);

        System.out.println("---------------------------------");

        Car car = ac.getBean(Car.class);
        Car car1 = ac.getBean(Car.class);
        System.out.println(car==car1);

        System.out.println("=================================");

        Zoo zoo = ac.getBean(Zoo.class);
        System.out.println(zoo);
    }
}
