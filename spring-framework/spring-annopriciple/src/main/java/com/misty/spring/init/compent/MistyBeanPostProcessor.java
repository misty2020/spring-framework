package com.misty.spring.init.compent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName MistyBeanPostProcessor
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/8 15:35
 * @Version 1.0
 **/
@Component
public class MistyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MistyBeanPostProcessor...postProcessBeforeInitialization:"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MistyBeanPostProcessor...postProcessAfterInitialization:"+beanName);
        return bean;
    }
}
