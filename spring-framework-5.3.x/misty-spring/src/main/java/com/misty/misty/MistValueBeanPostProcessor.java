package com.misty.misty;

import com.misty.spring.BeanPostProcessor;
import com.misty.spring.annotation.Component;
import com.misty.spring.annotation.MistyValue;

import java.lang.reflect.Field;

/**
 * @ClassName MistBean
 * @Description TODO
 * @Author HeTao
 * @Date 2021/9/28 14:36
 * @Version 1.0
 **/
@Component
public class MistValueBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        //System.out.println("初始化的："+beanName);
        Class<?> clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if(field.isAnnotationPresent(MistyValue.class)){
                field.setAccessible(true);
                MistyValue mistyValueAnnotation = field.getAnnotation(MistyValue.class);
                field.set(bean,mistyValueAnnotation.value());
            }
        }
        return bean;
    }
}
