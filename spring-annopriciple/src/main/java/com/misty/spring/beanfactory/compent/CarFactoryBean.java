package com.misty.spring.beanfactory.compent;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName CarFactoryBean
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 10:05
 * @Version 1.0
 **/
public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
