package com.esms.dao;

import com.esms.vo.MonthlyAttendanceCustomVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：11:00 2019/10/9
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MonthlyAttendanceCustomVoTest {
    @Autowired
    private MonthlyAttendanceCustomVoMapper customVoMapper = null;
    @Test
    public void test(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("e_account","");
        map.put("d_id",4);
        map.put("attendance_time","");

        List<MonthlyAttendanceCustomVo> monthlyAttendanceCustomVo
                = customVoMapper.selectMonthlyAttendanceCustomVoMapperByeAccountAnddIdAndTime(map);
        System.out.println(monthlyAttendanceCustomVo.toString());
    }
}
