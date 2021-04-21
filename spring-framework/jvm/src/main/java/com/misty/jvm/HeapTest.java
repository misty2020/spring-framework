package com.misty.jvm;

import java.util.ArrayList;

/**
 * @ClassName HeapTest
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/14 14:29
 * @Version 1.0
 **/
public class HeapTest {
    //100kb
    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<>();
        while (true){
            heapTests.add(new HeapTest());
            Thread.sleep(30);
        }
    }

}
