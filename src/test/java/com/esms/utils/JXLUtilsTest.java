package com.esms.utils;

import com.esms.dao.MonthlyAttendanceMapper;
import com.esms.dao.SalaryMapper;
import com.esms.po.MonthlyAttendance;
import com.esms.po.Salary;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JXLUtilsTest {
    @Autowired
    private SalaryMapper salaryMapper;
    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper;
    @Before
    public void before() {
    }
    @Test
    public void readMonthlyAttendanceTest() throws  Exception{
        File file = new File("D://ESMSexcel/Monthly_attendance_table/考勤表_2018-7.xls");
        List<MonthlyAttendance> monthlyAttendanceList = JXLUtils.readMonthlyAttendanceTable(file);
        for (MonthlyAttendance monthlyAttendance:monthlyAttendanceList){
            monthlyAttendanceMapper.insert(monthlyAttendance);
        }
    }
    @Test
    public void readRessiueTest(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        File file = new File("D://ESMSexcel/monthly_reissue_table/补发金额表_2018-7.xls");
        List<Salary> salaryList = JXLUtils.readReissueTable(file);
        for(Salary salary:salaryList){
            Salary temp = salaryMapper.selectByEidAndTime(salary.getEmployee().geteId(),dateFormat.format(salary.getsTime()));
            //如果数据库表salay不存在此记录，直接插入
            if(temp == null ){
                salaryMapper.insertSelective(salary);
            }else {
                //如果数据库表salay已存在此记录，修改补发金额数据
                salary.setsId(temp.getsId());
                salaryMapper.updateByPrimaryKeySelective(salary);
            }

        }
    }

}
