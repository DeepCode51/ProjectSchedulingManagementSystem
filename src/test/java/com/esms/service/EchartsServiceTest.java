package com.esms.service;

import com.esms.dao.SalaryMapper;
import com.esms.vo.EchMonthSalary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: ssm
 * @Author：方宏泰
 * @Description：
 * @Date：8:54 2019/10/9
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EchartsServiceTest {
    @Autowired
    private SalaryMapper salaryMapper;

    @Test
    public void getMonthSalaryTest(){
        List<EchMonthSalary> echMonthSalaryList = new ArrayList<EchMonthSalary>();
        Map<String,List<EchMonthSalary>> stringListMap = new HashMap<String, List<EchMonthSalary>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Integer year = Integer.parseInt(sdf.format(new Date()));    //当前年
        //近三年（不包括本年）
        String date = null;
        for(int i = year-3;i<year;i++){
            EchMonthSalary echMonthSalary = new EchMonthSalary();
            echMonthSalary.setYear(i+"年");
            List<Double> salary = new ArrayList<Double>();
            for(int month = 1; month<=12;month++) {
                if(month<10){
                    date = i + "-0"+month;
                }
                else {
                    date = i + "-"+month;
                }
                Double ymSalary = salaryMapper.selectAllSalaryByDate(date);  //查找某年某一月的总工资
                if (ymSalary == null) {
                    ymSalary = 0.00;
                }
                salary.add(ymSalary);
            }
            echMonthSalary.setSalary(salary);
            echMonthSalaryList.add(echMonthSalary);
        }
        stringListMap.put("list",echMonthSalaryList);
    }
}
