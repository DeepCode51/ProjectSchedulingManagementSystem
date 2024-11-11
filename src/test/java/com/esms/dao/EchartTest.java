package com.esms.dao;

import com.esms.dao.DepartmentMapper;
import com.esms.po.Department;
import com.esms.po.Salary;
import com.esms.vo.EchSalary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EchartTest {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private SalaryMapper salaryMapper;
    @Test
    public void selectAll(){
        List<Department> departmentList = departmentMapper.selectAll();
        for (Department department:departmentList){
            System.out.println(department);
        }
    }
    @Test
    public void countById(){
        System.out.println(employeeMapper.countByDid(1)+"--------------");
    }
    @Test
    public void selectSalaryByDepartment(){
        EchSalary echSalary = salaryMapper.selectSalaryByDepartment(1,"2018-07");
        System.out.println(echSalary);
        System.out.println();
    }
    @Test
    public void selectAllSalaryByDate(){
        Double ymSalary = salaryMapper.selectAllSalaryByDate("2018-07");
        System.out.println(ymSalary+"--------------------");
    }
}
