package com.esms.vo;

import java.util.List;

/**
 * @program: ssm
 * @Author：方宏泰
 * @Description：存放各部门，及其最低，平均，最高工资数值列表
 * @Date：10:19 2019/10/7
 * @Version: 1.0
 */
public class EchDepartmentSalary {
    //部门名称
    private String department;

    //工资列表：最低工资，平均工资，最高工资
    private List<Double> salary;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Double> getSalary() {
        return salary;
    }

    public void setSalary(List<Double> salary) {
        this.salary = salary;
    }
}
