package com.esms.service;

import com.esms.exception.CustomException;
import com.esms.po.Employee;
import com.esms.vo.EmployeeCustomVo;
import com.esms.po.Salary;
import com.esms.po.SystemManager;

import java.util.List;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：20:31 2019/10/6
 * @Version: 1.0
 */
public interface IUserInforService {
    public void updateSystemManagePassword(int id, SystemManager systemManager);
    public void updateEmployeePassword(int id, String oldPassword, String newPassword) throws CustomException;
    public EmployeeCustomVo getInforEmployee(int id);
    public int  updateEmploueeById(int id, Employee employee);
    // 查找员工个人的某年工资记录
    public List<Salary> getEmployeeSalaryList(int eId, String year);
}
