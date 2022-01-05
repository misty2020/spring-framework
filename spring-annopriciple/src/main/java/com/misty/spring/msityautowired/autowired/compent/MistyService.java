package com.misty.spring.msityautowired.autowired.compent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MistyService
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 14:52
 * @Version 1.0
 **/
@Service
public class MistyService {

    @Autowired
    private MistyDao mistyDao;

    public MistyDao getMistyDao() {
        return mistyDao;
    }

    public void setMistyDao(MistyDao mistyDao) {
        mistyDao = mistyDao;
    }

    @Override
    public String toString() {
        return "MistyService{" +
                "mistyDao=" + mistyDao +
                '}';
    }


}
