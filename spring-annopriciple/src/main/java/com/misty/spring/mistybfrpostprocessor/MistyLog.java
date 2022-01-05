package com.misty.spring.mistybfrpostprocessor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName MistyLog
 * @Description TODO
 * @Author HeTao
 * @Date 2020/11/11 16:40
 * @Version 1.0
 **/
public class MistyLog {

    @Value("1")
    private int flag;

    @Override
    public String toString() {
        return "MistyLog{" +
                "flag=" + flag +
                '}';
    }

    public MistyLog() {

        System.out.println("我是MistyLog的构造方法");
    }



    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
