package com.misty.spring.postprocess.filter;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @ClassName MistyBeanPostProcessor
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 14:40
 * @Version 1.0
 **/
@Component
public class MistyBeanPostProcessor implements BeanPostProcessor, InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MistyBeanPostProcessor...postProcessBeforeInitialization:"+beanName);
        if (beanName.equals("compent")) {
            System.out.println(beanName+"的后置处理器的before");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MistyBeanPostProcessor...postProcessAfterInitialization:"+beanName);
        if (beanName.equals("compent")) {
            System.out.println(beanName+"的后置处理器的after");
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanName.equals("compent")){
            System.out.println(beanName+"实例化之前");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(beanName.equals("compent")){
            System.out.println(beanName+"实例化之后");
        }
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        return pvs;
    }
}
