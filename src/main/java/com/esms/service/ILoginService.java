package com.esms.service;

import com.esms.exception.CustomException;
import com.esms.po.Employee;
import com.esms.po.SystemManager;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：2:20 2019/10/6
 * @Version: 1.0
 */
public interface ILoginService {
    public Employee findEmployeeByIdAndPassword(String account, String password) throws CustomException;
    public SystemManager findSystemManagerByIdAndPassword(String account, String password) throws CustomException;
    public Employee findEmployeeById(int id);
    public SystemManager findSystemManagerById(int id);
}
