package com.misty.spring.msityautowired.autowired.compent;


/**
 * @ClassName MistyDao
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 14:52
 * @Version 1.0
 **/
public class MistyDao {

    private int flag=1;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MistyDao{" +
                "flag=" + flag +
                '}';
    }
}
