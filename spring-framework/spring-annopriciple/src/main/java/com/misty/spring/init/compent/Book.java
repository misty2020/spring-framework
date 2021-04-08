package com.misty.spring.init.compent;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName Book
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/8 15:25
 * @Version 1.0
 **/
@Component
public class Book {

    public Book() {
        System.out.println("book 的构造方法");
    }

    @PostConstruct
    public void init(){
        System.out.println("book 的PostConstruct标志初始化方法");
    }

    @PreDestroy
    public void destory(){
        System.out.println("booK 的PreDestroy标注销毁方法");
    }
}
