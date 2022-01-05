package com.misty.spring.concurrent;

import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Misty
 * @Description TODO
 * @Author HeTao
 * @Date 2020/12/11 14:25
 * @Version 1.0
 **/
public class MistyMain {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        CountDownLatch latch = new CountDownLatch(3);
        Worker w1 = new Worker(latch,"mk");
        Worker w2 = new Worker(latch,"ls");
        Worker w3 = new Worker(latch,"zs");

        Boss boss = new Boss(latch,"ks");

        executor.execute(w3);
        executor.execute(w2);
        executor.execute(w1);
        executor.execute(boss);
    }
}
