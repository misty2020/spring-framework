package com.misty.jvm.classload;

/**
 * @ClassName User
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/21 10:39
 * @Version 1.0
 **/
public class User {

    private int uid;

    private String name;

    public User(int uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("uid为"+uid+"即将被回收");
    }

//    public void sout(){
//        Object o = new Object();
//        System.out.println("自定义加载器");
//    }
}
