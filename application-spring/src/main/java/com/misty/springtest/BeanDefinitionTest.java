package com.misty.springtest;

import com.misty.common.User;
import com.misty.config.AppConfig;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName BeanDefinitionTest
 * @Description bean定义
 * @Author HeTao
 * @Date 2022/1/5 13:47
 * @Version 1.0
 **/
public class BeanDefinitionTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 生成一个BeanDefinition对象，并设置beanClass为User.class，并注册到ApplicationContext中
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanDefinition.setScope("prototype"); // 设置作用域
        beanDefinition.setInitMethodName("init"); // 设置初始化方法
        beanDefinition.setLazyInit(false); // 设置懒加载
        context.registerBeanDefinition("user",beanDefinition);
        Object user = context.getBean("user");
        System.out.println(user);
    }
}
