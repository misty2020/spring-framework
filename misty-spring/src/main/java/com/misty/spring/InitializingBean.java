package com.misty.spring;

/**
 * @ClassName InitializingBean
 * @Description TODO
 * @Author HeTao
 * @Date 2021/9/28 14:25
 * @Version 1.0
 **/
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
