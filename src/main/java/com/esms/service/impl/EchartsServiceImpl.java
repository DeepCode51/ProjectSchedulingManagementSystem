package com.esms.service.impl;

import com.esms.dao.DepartmentMapper;
import com.esms.dao.EmployeeMapper;
import com.esms.dao.SalaryMapper;
import com.esms.po.Department;
import com.esms.po.Employee;
import com.esms.service.IEchartsService;
import com.esms.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 方宏泰
 * @Description:
 * @Date: 22:30 2019/10/6
 **/
@Service
public class EchartsServiceImpl implements IEchartsService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public Map<String, List<EchEmployeeNums>> getEmployeeNums() {
        /**
         * @Author: 方宏泰
         * @Description: 
         * @Date: 8:11 2019/10/7
         * @Param: []
         * @Return: java.util.Map<java.lang.String,java.util.List<com.esms.vo.EchEmployeeNums>>
         **/
        List<EchEmployeeNums> echEmployeeNumsList = new ArrayList();
        Map<String,List<EchEmployeeNums>> map = new HashMap<String,List<EchEmployeeNums>>();
        List<Department> departmentList = (List<Department>) departmentMapper.selectAll();
        int nums = 0;
        for (Department department:departmentList){
            //统计部门员工人数
            nums = employeeMapper.countByDid(department.getdId());
            EchEmployeeNums echEmployeeNums = new EchEmployeeNums();
            //填入部门名
            echEmployeeNums.setDepartment(department.getdName());
            //填入部门员工人数
            echEmployeeNums.setNum(nums);
            echEmployeeNumsList.add(echEmployeeNums);
            nums = 0;   //清零
        }
        map.put("list",echEmployeeNumsList);
        return map;
    }

    @Override
    public Map<String, List<EchDepartmentSalary>> getDepartmentSalary(String date) {
        /**
         * @Author: 方宏泰
         * @Description:各部门工资折线图
         * @Date: 14:36 2019/10/7
         * @Param: []
         * @Return: java.util.Map<java.lang.String,java.util.List<com.esms.vo.EchDepartmentSalary>>
         **/
        List<EchDepartmentSalary> echDepartmentSalaryList = new ArrayList<EchDepartmentSalary>();

        Map<String,List<EchDepartmentSalary>> stringListMap = new HashMap<String, List<EchDepartmentSalary>>();
        List<Department> departmentList = (List<Department>) departmentMapper.selectAll();
        //遍历所有部门
        for (Department department:departmentList){
            EchDepartmentSalary echDepartmentSalary = new EchDepartmentSalary();
            //填入部门名称
            echDepartmentSalary.setDepartment(department.getdName());
            //查找每个部门最高，平均，最低工资,并用vo类echSalary接收
            EchSalary echSalary = salaryMapper.selectSalaryByDepartment(department.getdId(),date);
            //查找不到数据，则赋值为0
            if(echSalary==null){
                echSalary = new EchSalary(0.00,0.00,0.00);
            }
            //填入每个部门最高，平均，最低工资
            List<Double> salary = new ArrayList<Double>();
            salary.add(echSalary.getMinSalary());
            salary.add(echSalary.getAvgSalary());
            salary.add(echSalary.getMaxSalary());

            echDepartmentSalary.setSalary(salary);
            //填入一条数据（department,salary[10,20,30]）到VO
            echDepartmentSalaryList.add(echDepartmentSalary);
        }
        stringListMap.put("list",echDepartmentSalaryList);
        return stringListMap;
    }

    @Override
    public Map<String, List<EchSalaryPercent>> getSalaryPercent(String date,int state) {
        List<EchSalaryPercent> echSalaryPercentList = new ArrayList<EchSalaryPercent>();
        Map<String,List<EchSalaryPercent>> map = new HashMap<String,List<EchSalaryPercent>>();
        List<Department> departmentList = (List<Department>) departmentMapper.selectAll();
        //遍历所有部门
        for (Department department:departmentList){
            EchSalaryPercent echSalaryPercent = new EchSalaryPercent();
            //填入部门名称
            echSalaryPercent.setDepartment(department.getdName());
            //查找每个部门工资总数,并用vo类echSalaryDepartment接收
            //时间为年月
            Double allSalary = 0.00;
            if(state == 0){
                allSalary = salaryMapper.selectAllSalaryByDepartment(department.getdId(),date);
            }else {
                allSalary = salaryMapper.selectAllSalaryByDepAndYear(department.getdId(),date);
            }
            //查找不到数据，则赋值为0
            if(allSalary==null){
                allSalary = 0.00;
            }
            //填入每个部门工资总数
            echSalaryPercent.setSalary(allSalary);
            //填入一条数据到VO
            echSalaryPercentList.add(echSalaryPercent);
        }
        map.put("list",echSalaryPercentList);
        return map;
    }

    @Override
    public Map<String, List<EchMonthSalary>> getMonthSalary() {
        List<EchMonthSalary> echMonthSalaryList = new ArrayList<EchMonthSalary>();
        Map<String,List<EchMonthSalary>> stringListMap = new HashMap<String, List<EchMonthSalary>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Integer year = Integer.parseInt(sdf.format(new Date()));    //当前年
        String date = null;
        //近三年（不包括本年）
        for(int i = year-2;i<=year;i++){
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
        return stringListMap;
    }
}
