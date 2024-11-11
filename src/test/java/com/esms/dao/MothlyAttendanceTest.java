package com.esms.dao;

import com.esms.po.MonthlyAttendance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MothlyAttendanceTest {
    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper = null;

    @Test
//    级联查询懒加载
    public void testSelectByPrimaryKey(){
        MonthlyAttendance monthlyAttendance = monthlyAttendanceMapper.selectByPrimaryKey(1);
        System.out.println(monthlyAttendance.toString());
    }

    @Test
    public void test1(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("eId",11);
        map.put("attendanceTime","2018");
        List<MonthlyAttendance> list = monthlyAttendanceMapper.selectMonthlyAttendanceMapperByeEidAndTime(map);
        System.out.println(list.size());
    }
}
