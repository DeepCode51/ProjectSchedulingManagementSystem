package com.esms.dao;

import com.esms.po.Salary;
import com.esms.vo.EchSalary;

import java.util.List;
import java.util.Map;

public interface SalaryMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    Salary selectByEidAndTime(Integer eId, String time);

    Double selectMaxSalaryByDepartment(Integer dId,String date);
    //查每个最低，平均，最高工资
    EchSalary selectSalaryByDepartment(Integer dId, String date);
    //查每个工资总数,时间年月
    Double selectAllSalaryByDepartment(Integer dId,String date);
    //查每个工资总数,时间年
    Double selectAllSalaryByDepAndYear(Integer dId,String date);
    // 查找员工个人的某年工资记录
    List<Salary> selectEmployeeSalaryList(Integer eId, String data);
    List<Salary> selectByeId(Integer eId);
    //根据年月时间查工资总数
    Double selectAllSalaryByDate(String date);
    List<Salary> test(String eAccount);
    List<Salary> selectByEaccountDIdDate(Map<String,Object> map);

    List<Salary> selectByeTimeAndStatus(String date, int status);
    Salary selectByEidAndTimeAndStatus(Integer eId, String time, int status);

    List<Salary> selectByEaccountDIdDateState(Map<String,Object> map);
}