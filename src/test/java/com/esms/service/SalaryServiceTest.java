package com.esms.service;

import com.esms.exception.CustomException;
import com.esms.service.impl.SalaryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：0:30 2019/10/12
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SalaryServiceTest {
    @Autowired
    private SalaryServiceImpl salaryService = null;
    @Test
    public void testInsertSalaryByAcountAndDate(){
        try {
            salaryService.insertSalaryByAcountAndDate("1","2018-08");
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

}
