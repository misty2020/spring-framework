package com.misty.jmm;

/**
 * @ClassName volatileDemo
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/15 15:27
 * @Version 1.0
 **/
public class VolatileDemo {

    public static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("wating data .....");
                while (!flag) {
                }
                System.out.println("============success");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareData();
            }
        }).start();
    }

    public static void prepareData() {
        System.out.println("start deal with data.....");
        flag = true;
        System.out.println("end deal with data.....");
    }
}
