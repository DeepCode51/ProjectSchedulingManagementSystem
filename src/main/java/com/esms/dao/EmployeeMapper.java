package com.esms.dao;

import com.esms.po.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Employee selectByAccountAndPassword(Employee employee);

    int countByDid(Integer eId);
    //判断是否有员工依赖该工龄
    int countByRbid(Integer eRank);

    Employee selectByAccount(String eAcount);

//    void deleteByQuery(int[] ids);

    Employee findByeAccount(String eAccount);

    List<Employee> selectAll();

    int isExistEmployee(String eAccount);

    int selectEidByEaccount(String eAccount);
}