package com.misty.spring.beanfactory.compent;

import org.springframework.beans.factory.FactoryBean;

import java.sql.DriverManager;

/**
 * @ClassName DriverFactoryBean
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 10:06
 * @Version 1.0
 **/
public class DriverFactoryBean implements FactoryBean {

    private String jdbcUrl;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Override
    public Object getObject() throws Exception {
        return DriverManager.getDriver(jdbcUrl);
    }

    @Override
    public Class<?> getObjectType() {
        return java.sql.Driver.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
