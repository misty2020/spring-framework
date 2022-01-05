package com.misty.springtest;

import com.misty.common.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @ClassName BeanFactoryTest
 * @Description bean工厂
 * @Author HeTao
 * @Date 2022/1/5 14:25
 * @Version 1.0
 **/
public class BeanFactoryTest {

    public static void main(String[] args) {
        //ApplicationContext 继承 DefaultListableBeanFactory
        //DefaultListableBeanFactory是非常强大的，支持很多功能，可以通过查看 DefaultListableBeanFactory的类继承实现结构来看
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanFactory.registerBeanDefinition("user", beanDefinition);
        System.out.println(beanFactory.getBean("user"));
    }
}
