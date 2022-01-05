package com.misty.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName User
 * @Description TODO
 * @Author HeTao
 * @Date 2022/1/5 13:46
 * @Version 1.0
 **/
@Data
public class User {

    private String name;

    @Value(value = "123")
    private Integer age;

    public void init(){
        this.name = "小明";
        this.age  = 12;
    }

}
