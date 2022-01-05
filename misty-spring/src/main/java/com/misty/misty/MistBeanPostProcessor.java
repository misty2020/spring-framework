package com.misty.misty;

import com.misty.spring.BeanPostProcessor;
import com.misty.spring.annotation.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName MistBean
 * @Description TODO
 * @Author HeTao
 * @Date 2021/9/28 14:36
 * @Version 1.0
 **/
@Component
public class MistBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        //System.out.println("初始化的："+beanName);

        if("orderService".equals(beanName)){
            Object proxyBean = Proxy.newProxyInstance(MistBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("切面逻辑");
                    return method.invoke(bean, args);
                }
            });
            return proxyBean;
        }
        return bean;
    }
}
