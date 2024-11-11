package com.esms.vo;

import com.esms.po.Department;
import com.esms.po.Employee;
import com.esms.po.MonthlyAttendance;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：10:44 2019/10/9
 * @Version: 1.0
 */
public class MonthlyAttendanceCustomVo {
    private MonthlyAttendance monthlyAttendance = null;
    private Employee employee = null;
    private Department department = null;

    @Override
    public String toString() {
        return "MonthlyAttendanceCustomVo{" +
                "monthlyAttendance=" + monthlyAttendance +
                ", employee=" + employee +
                ", department=" + department +
                '}';
    }

    public MonthlyAttendance getMonthlyAttendance() {
        return monthlyAttendance;
    }

    public void setMonthlyAttendance(MonthlyAttendance monthlyAttendance) {
        this.monthlyAttendance = monthlyAttendance;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
