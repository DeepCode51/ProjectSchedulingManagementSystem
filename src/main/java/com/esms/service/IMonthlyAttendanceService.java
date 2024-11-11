package com.esms.service;

import com.esms.po.MonthlyAttendance;
import org.springframework.stereotype.Service;

/**
 * @Author: xjx
 * @Date: 2019/10/9 8:51
 */
public interface IMonthlyAttendanceService {
    void deleteByPrimaryKey(int id);

    void deleteByQuery(int[] ids);

    MonthlyAttendance selectByPrimaryKey(int id);

    void updateByPrimaryKeySelective(MonthlyAttendance monthlyAttendance);
}
