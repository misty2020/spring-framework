package com.misty.spring.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Boss
 * @Description TODO
 * @Author HeTao
 * @Date 2020/12/11 14:21
 * @Version 1.0
 **/
public class Boss implements Runnable {

    private CountDownLatch downLatch;

    private String name;

    public Boss(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }

    public Boss() {
    }

    public CountDownLatch getDownLatch() {
        return downLatch;
    }

    public void setDownLatch(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("老板正在等所有的工人干完活......");
        try {
            this.downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("工人活都干完了，老板开始检查了！");
    }
}
