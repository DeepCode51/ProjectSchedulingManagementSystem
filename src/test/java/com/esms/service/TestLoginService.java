package com.esms.service;

import com.esms.exception.CustomException;
import com.esms.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：2:39 2019/10/6
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestLoginService {
    @Autowired
    private LoginServiceImpl loginService = null;
    @Test
    public void testFindEmployeeByIdAndPassword() throws Exception {
        loginService.findEmployeeByIdAndPassword("1","1");
    }

    @Test
    public void testFindSystemManagerByIdAndPassword()  {
        try {
            loginService.findSystemManagerByIdAndPassword("admin","1");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
