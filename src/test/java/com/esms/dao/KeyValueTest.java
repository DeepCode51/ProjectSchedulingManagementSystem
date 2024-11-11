package com.esms.dao;

import com.esms.po.KeyValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：14:52 2019/10/10
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class KeyValueTest {
    @Autowired
    private KeyValueMapper keyValueMapper;
    @Test
    public void test(){
        KeyValue keyValue = keyValueMapper.selectBykvKey("traffic_pay");
        System.out.println(keyValue.getKvValue());
    }
}
