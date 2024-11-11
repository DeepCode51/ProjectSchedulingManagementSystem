package com.esms.dao;

import com.esms.po.MonthlyAttendance;

import java.util.List;
import java.util.Map;

public interface MonthlyAttendanceMapper {
    int deleteByPrimaryKey(Integer maId);

    int insert(MonthlyAttendance record);

    int insertSelective(MonthlyAttendance record);

    MonthlyAttendance selectByPrimaryKey(Integer maId);

    int updateByPrimaryKeySelective(MonthlyAttendance record);

    int updateByPrimaryKey(MonthlyAttendance record);

    MonthlyAttendance selectByeIdAndDate(int eId, String date);

    void deleteByQuery(int[] ids);

    List<MonthlyAttendance> selectMonthlyAttendanceMapperByeEidAndTime (Map<String, Object> map);
}