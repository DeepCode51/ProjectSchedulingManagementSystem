package com.esms.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：2:43 2019/10/6
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
@WebAppConfiguration
public class TestLoginController {
    @Autowired
    private LoginController loginController = null;
    private MockMvc mockMvc;

    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup().build();
    }
    @Test
    public void testEmployeeLogin(){
    }
}
