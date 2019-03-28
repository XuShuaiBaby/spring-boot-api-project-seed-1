package com.company.project.web;

import com.company.project.Application;
import com.company.project.model.UserBaseInfo;
import com.company.project.service.UserBaseInfoService;
import com.conpany.project.Tester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

public class UserBaseInfoControllerTest extends Tester {

    @Autowired
    private UserBaseInfoService userBaseInfoService;

    @Test
    public void testOne() {
        /*UserBaseInfo userBaseInfo = new UserBaseInfo();
        userBaseInfo.setId(3);
        userBaseInfo.setUserName("xu2");
        userBaseInfo.setPassWord("111111");
        userBaseInfoService.update(userBaseInfo);*/
        UserBaseInfo userBaseInfo1 = new UserBaseInfo();
        userBaseInfo1.setUserName("xu1");
        userBaseInfo1.setPassWord("111111");
        userBaseInfoService.save(userBaseInfo1);
    }
}