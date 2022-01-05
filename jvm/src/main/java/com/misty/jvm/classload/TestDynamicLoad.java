package com.misty.jvm.classload;

/**
 * @ClassName TestDynamicLoad
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/21 10:42
 * @Version 1.0
 **/
public class TestDynamicLoad {

    static {
        System.out.println("*************load TestDynamicLoad************");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("*************load test************");
        B b = null; //B不会加载 除非这里执行 new  B()
    }

    static class A {
        static {
            System.out.println("*************load A************");
        }

        public A() {
            System.out.println("*************initial A************");
        }
    }

    static class B {
        static {
            System.out.println("*************load B************");
        }

        public B() {
            System.out.println("*************initial B************");
        }
    }
}
