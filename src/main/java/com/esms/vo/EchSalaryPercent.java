package com.esms.vo;

/**
 * @program: ssm
 * @Author：方宏泰
 * @Description：
 * @Date：8:45 2019/10/8
 * @Version: 1.0
 */
public class EchSalaryPercent {
    private String Department = null;
    private Double Salary = 0.00;

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }
    public EchSalaryPercent(){}

    public EchSalaryPercent(String department, Double salary) {
        Department = department;
        Salary = salary;
    }
}
