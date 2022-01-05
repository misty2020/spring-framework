package com.misty.jmm;

/**
 * @ClassName VolatileDemoTest
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/15 15:35
 * @Version 1.0
 **/
public class VolatileDemoTest {

    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0 ;j< 1000 ;j++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(num);
    }

    public static void increase() {
        num++;
    }
}
