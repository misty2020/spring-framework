package com.misty.spring.msityautowired.autowired.compent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassName BaiDuService
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 14:52
 * @Version 1.0
 **/
@Service
public class BaiDuService {

    @Autowired
    private MistyDao mistyDao2;

    @Override
    public String toString() {
        return "BaiDuService{" +
                "mistyDao=" + mistyDao2 +
                '}';
    }

    public MistyDao getMistyDao() {
        return mistyDao2;
    }

    public void setMistyDao(MistyDao mistyDao2) {
        mistyDao2 = mistyDao2;
    }
}
