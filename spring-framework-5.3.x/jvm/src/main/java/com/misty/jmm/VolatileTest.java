package com.misty.jmm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName VolatileTest
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/15 15:43
 * @Version 1.0
 **/
public class VolatileTest {

    static  int x,y = 0;

    public static void main(String[] args) throws InterruptedException {
        Set<String> resultSet = new HashSet<>();
        Map<String,Integer> resultMap = new HashMap<>();

        for (int i = 0; i<1000000 ;i++){
            x = 0;
            y = 0;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = y;
                    x = 1;
                    resultMap.put("a",a);
                }
            });

            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    int b = x;
                    y = 1;
                    resultMap.put("b",b);
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            resultSet.add("a="+resultMap.get("a")+","+"b="+resultMap.get("b"));
            System.out.println(resultSet);
        }

    }
}
