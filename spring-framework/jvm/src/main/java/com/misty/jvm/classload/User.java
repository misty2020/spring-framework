package com.misty.jvm.classload;

/**
 * @ClassName User
 * @Description TODO
 * @Author HeTao
 * @Date 2021/4/21 10:39
 * @Version 1.0
 **/
public class User {

    private String uid;

    private String name;

    private String sex;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void sout(){
        Object o = new Object();
        System.out.println("自定义加载器");
    }
}
