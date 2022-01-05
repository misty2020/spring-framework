package com.misty.spring;

/**
 * @ClassName BeanPostProcessor
 * @Description TODO
 * @Author HeTao
 * @Date 2021/9/28 14:34
 * @Version 1.0
 **/
public interface BeanPostProcessor {


    /**
     * 初始化前
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    /**
     * 初始化后
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    default Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
