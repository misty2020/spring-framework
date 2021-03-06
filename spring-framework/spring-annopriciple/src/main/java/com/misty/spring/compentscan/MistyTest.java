package com.misty.spring.compentscan;

import com.misty.spring.compentscan.config.MistyConfig;
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
    }
}
