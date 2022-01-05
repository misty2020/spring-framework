package com.misty.spring.beanfactorypostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName MistyBeanFactoryPostProcessor
 * @Description 创建bean工厂前置拦截器  作用范围   bean定义之后   bean 实例化之前
 * @Author HeTao
 * @Date 2020/11/11 16:41
 * @Version 1.0
 **/
@Component
public class MistyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("IOC 容器调用了MistyBeanFactoryPostProcessor的postProcessBeanFactory方法");
        for(String name:beanFactory.getBeanDefinitionNames()) {
            if("mistyLog".equals(name)) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
                beanDefinition.setLazyInit(true);
            }

        }
    }
}
