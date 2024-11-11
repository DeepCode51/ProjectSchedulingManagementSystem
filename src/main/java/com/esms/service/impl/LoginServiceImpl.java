package com.esms.service.impl;

import com.esms.dao.EmployeeMapper;
import com.esms.dao.SystemManagerMapper;
import com.esms.exception.CustomException;
import com.esms.po.Employee;
import com.esms.po.SystemManager;
import com.esms.service.ILoginService;
import com.esms.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：2:21 2019/10/6
 * @Version: 1.0
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private EmployeeMapper employeeMapper = null;
    @Autowired
    private SystemManagerMapper systemManagerMapper = null;

    public Employee findEmployeeByIdAndPassword(String account, String password) throws CustomException {
        String encode = MD5Utils.encodeByMD5(password);
//        System.out.println(encode);
        Employee employee = new Employee();
        employee.seteAccount(account);
        employee.setePassword(encode);
//        employee.setePassword(password);
        employee.seteIsdel(1);
        Employee employee1 = employeeMapper.selectByAccountAndPassword(employee);
        if(employee1 == null){
            throw new CustomException("工号或密码错误");
        }
        return employee1;
    }

    @Override
    public SystemManager findSystemManagerByIdAndPassword(String account, String password) throws CustomException {
        String encode = MD5Utils.encodeByMD5(password);
        SystemManager systemManager = new SystemManager();
        systemManager.setSmAccount(account);
        systemManager.setSmPassword(encode);
//        systemManager.setSmPassword(password);
        SystemManager systemManager1 = systemManagerMapper.selectByAccountAndPassword(systemManager);
        if(systemManager1 == null){
            throw new CustomException("管理员账号或密码错误");
        }
        return systemManager1;
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public SystemManager findSystemManagerById(int id) {
        return systemManagerMapper.selectByPrimaryKey(id);
    }
}
