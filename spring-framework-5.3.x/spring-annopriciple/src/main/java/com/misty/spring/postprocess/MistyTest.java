package com.misty.spring.postprocess;

import com.misty.spring.postprocess.config.MistyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MistyTest
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 10:15
 * @Version 1.0
 **/
public class MistyTest {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MistyConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanName为："+beanDefinitionName);
        }
        ac.close();
    }
}
