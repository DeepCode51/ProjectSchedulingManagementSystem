package com.esms.dao;

import com.esms.po.Salary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SalaryTest {
    @Autowired
    private SalaryMapper salaryMapper = null;
    @Test
    public void testSelectByPrimaryKey(){
        Salary salary = salaryMapper.selectByPrimaryKey(1);
        System.out.println(salary.toString());
    }

   @Test
    public void selectByEaccountDIdDateTest(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("eAccount",1);
        map.put("dId",1);
        map.put("sTime","");
        List<Salary> salaryList = salaryMapper.selectByEaccountDIdDate(map);
        System.out.println(salaryList.toString());
    }
}
