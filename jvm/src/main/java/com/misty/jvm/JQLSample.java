package com.misty.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName JQLSample
 * @Description TODO
 * @Author HeTao
 * @Date 2021/5/19 14:38
 * @Version 1.0
 **/
public class JQLSample {
    // -XX:+UseCompressedOops           默认开启的压缩所有指针
    // -XX:+UseCompressedClassPointers  默认开启的压缩对象头里的类型指针Klass Pointer
    // Oops : Ordinary Object Pointers
    public static void main(String[] args) {
        ClassLayout layout = ClassLayout.parseInstance(new Object());
        System.out.println(layout.toPrintable());

        System.out.println();
        ClassLayout layout1 = ClassLayout.parseInstance(new int[]{});
        System.out.println(layout1.toPrintable());

        System.out.println();
        ClassLayout classLayout = ClassLayout.parseInstance(new A());
        System.out.println(classLayout.toPrintable());
    }

    private static class A {
                                    //8B mark word
                                    //4B Klass Pointer   如果关闭压缩-XX:-UseCompressedClassPointers或-XX:-UseCompressedOops，则占用8B
        private int count;          //4B
        private byte b;             //1B
        private String name;        //4B  如果关闭压缩-XX:-UseCompressedOops，则占用8B
        private Object o;           //4B  如果关闭压缩-XX:-UseCompressedOops，则占用8B
    }
}
