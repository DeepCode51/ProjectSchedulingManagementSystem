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
 * @Date：10:33 2019/10/10
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MonthlyAttendanceCustomVoTest {
    @Autowired
    private SalaryServiceImpl salaryService = null;
     @Test
    public void test(){
         try {
             salaryService.insertSalaryByAcountAndDate("4","2017-06");
         } catch (CustomException e) {
             e.printStackTrace();
         }
     }
}
