package com.misty.spring.mistybfrpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @ClassName MistyBeanDefinationRegisterPostProcessor
 * @Description 创建BeanDefinationRegisterPostProcessor前置拦截器  作用范围  在自定义bean定义加载到spring 容器之前
 * @Author HeTao
 * @Date 2020/11/11 16:54
 * @Version 1.0
 **/
@Component
public class MistyBeanDefinationRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MistyBeanDefinationRegisterPostProcessor的postProcessBeanDefinitionRegistry方法");
        System.out.println("bean定义的数据量:"+registry.getBeanDefinitionCount());
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(MistyLog.class);
        registry.registerBeanDefinition("mistyLog",rootBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MistyBeanDefinationRegisterPostProcessor的postProcessBeanFactory方法");
        System.out.println("bean定义的数据量:"+beanFactory.getBeanDefinitionCount());
    }
}
