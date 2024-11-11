package com.esms.service;

import com.esms.po.Department;
import com.esms.vo.EchDepartmentSalary;
import com.esms.vo.EchEmployeeNums;
import com.esms.vo.EchMonthSalary;
import com.esms.vo.EchSalaryPercent;

import java.util.List;
import java.util.Map;

public interface IEchartsService {
    Map<String,List<EchEmployeeNums>> getEmployeeNums();
    Map<String,List<EchDepartmentSalary>> getDepartmentSalary(String date);
    Map<String,List<EchSalaryPercent>> getSalaryPercent(String date,int state);
    Map<String,List<EchMonthSalary>> getMonthSalary();
}
