package com.misty.jvm;

import com.misty.jvm.classload.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName OOMTest
 * @Description TODO
 * @Author HeTao
 * @Date 2021/5/19 15:20
 * @Version 1.0
 **/
public class OOMTest {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            new User(j--, UUID.randomUUID().toString());
        }
    }
}
