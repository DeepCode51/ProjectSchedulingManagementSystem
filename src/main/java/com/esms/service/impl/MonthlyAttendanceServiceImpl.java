package com.esms.service.impl;

import com.esms.dao.MonthlyAttendanceMapper;
import com.esms.po.MonthlyAttendance;
import com.esms.service.IMonthlyAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xjx
 * @Date: 2019/10/9 8:52
 */
@Service
public class MonthlyAttendanceServiceImpl implements IMonthlyAttendanceService {
    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper;
    public MonthlyAttendance t(int id) {
        return monthlyAttendanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteByPrimaryKey(int id) {
        monthlyAttendanceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByQuery(int[] ids) {
        monthlyAttendanceMapper.deleteByQuery(ids);
    }

    @Override
    public MonthlyAttendance selectByPrimaryKey(int id) {
        return monthlyAttendanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKeySelective(MonthlyAttendance monthlyAttendance) {
        monthlyAttendanceMapper.updateByPrimaryKeySelective(monthlyAttendance);
    }
}
