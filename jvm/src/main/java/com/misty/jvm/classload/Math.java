package com.misty.jvm.classload;

/**
 * @ClassName Math
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/21 9:56
 * @Version 1.0
 **/
public class Math {

    public static final int initData = 666;

    public static User user = new User();

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }

    public int compute() {
        //一个方法对应一块内存区域
        int a = 1;
        int b = 2;
        int c = (a+b)*10;
        return c;
    }
}
