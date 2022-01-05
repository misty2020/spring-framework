package com.misty.spring.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Worker
 * @Description TODO
 * @Author HeTao
 * @Date 2020/12/11 14:16
 * @Version 1.0
 **/
public class Worker implements Runnable {

    private CountDownLatch downLatch;

    private String name;

    public CountDownLatch getDownLatch() {
        return downLatch;
    }

    public void setDownLatch(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    public Worker(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }

    public Worker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        this.doWork();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name+"活干完了！");
        this.downLatch.countDown();
    }

    private void doWork() {
        System.out.println(this.name+"正在干活");
    }
}
