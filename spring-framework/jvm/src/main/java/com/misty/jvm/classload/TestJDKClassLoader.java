package com.misty.jvm.classload;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @ClassName TestJDKClassLoader
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/21 10:47
 * @Version 1.0
 **/
public class TestJDKClassLoader {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.AESKeyGenerator.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
        System.out.println();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = systemClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassLoader.getParent();
        System.out.println("the bootstrapLoader : "+ bootstrapLoader);
        System.out.println("the extClassLoader : "+ extClassLoader);
        System.out.println("the systemClassLoader : "+ systemClassLoader);
        System.out.println();

        System.out.println("bootstrapLoader加载以下文件： ");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }

        System.out.println();
        System.out.println("extClassLoader加载以下文件： ");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader加载以下文件： ");
        System.out.println(System.getProperty("java.class.path"));
    }
}
