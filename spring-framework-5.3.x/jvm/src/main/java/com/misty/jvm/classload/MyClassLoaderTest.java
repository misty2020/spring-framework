package com.misty.jvm.classload;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName MyClassLoaderTest
 * @Description 自定义类加载器
 * @Author HeTao
 * @Date 2021/4/21 15:11
 * @Version 1.0
 **/
public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader{
        private String classpath;

        public MyClassLoader(String classpath) {
            this.classpath = classpath;
        }

        public String getClasspath() {
            return classpath;
        }

        public void setClasspath(String classpath) {
            this.classpath = classpath;
        }

        @Override
        protected Class<?> findClass(final String name) throws ClassNotFoundException {
            try{
                byte[] data = loadByte(name);
                //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节 数组。
                return defineClass(name,data,0,data.length);
            }catch (Exception e){
                throw new ClassNotFoundException();
            }
        }

        private byte[] loadByte(String name) throws IOException {
            name = name.replaceAll("\\.","/");
            FileInputStream fileInputStream = new FileInputStream(classpath + "/" + name + ".class");
            int len = fileInputStream.available();
            byte[] data = new byte[len];
            fileInputStream.read(data);
            fileInputStream.close();
            return data;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //初始化自定义类加载器  会先初始化父类classloader 其中会把自定义类加载的父加载器设置为应用程序类加载器AppClassLoader
        MyClassLoader classLoader = new MyClassLoader("D:/test");
        Class<?> clazz = classLoader.loadClass("com.misty.jvm.classload.User1");
        Object o = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(o,null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }
}
