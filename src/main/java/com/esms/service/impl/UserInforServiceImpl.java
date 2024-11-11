package com.esms.service.impl;

import com.esms.dao.*;
import com.esms.exception.CustomException;
import com.esms.po.*;
import com.esms.service.IUserInforService;
import com.esms.utils.MD5Utils;
import com.esms.vo.EmployeeCustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：20:31 2019/10/6
 * @Version: 1.0
 */
@Service
public class UserInforServiceImpl implements IUserInforService {
    @Autowired
    private SystemManagerMapper systemManagerMapper = null;
    @Autowired
    private EmployeeMapper employeeMapper = null;
    @Autowired
    private RankBonusMapper rankBonusMapper = null;
    @Autowired
    private PositionMapper positionMapper = null;
    @Autowired
    private DepartmentMapper departmentMapper = null;
    @Autowired
    private EmployeeCustomVoMapper employeeCustomVoMapper = null;
    @Autowired
    private SalaryMapper salaryMapper = null;

    @Override
    public void updateSystemManagePassword(int id, SystemManager systemManager) {
        systemManagerMapper.updateByPrimaryKey(systemManager);
    }

    @Override
    public void updateEmployeePassword(int id, String oldPassword, String newPassword) throws CustomException {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        String encodeOld = MD5Utils.encodeByMD5(oldPassword);
        if (encodeOld.equals(employee.getePassword())) {
            String encodeNew = MD5Utils.encodeByMD5(newPassword);
            employee.setePassword(encodeNew);
            employeeMapper.updateByPrimaryKeySelective(employee);
        } else {
            throw new CustomException("原密码错误");
        }
    }

    @Override
    public EmployeeCustomVo getInforEmployee(int id) {
//        EmployeeCustomVo employeeCustomVo = new EmployeeCustomVo();
//        Employee employee = employeeMapper.selectByPrimaryKey(id);
//        Department department = departmentMapper.selectByPrimaryKey(employee.getdId());
//        Position position = positionMapper.selectByPrimaryKey(employee.getpId());
//        RankBonus rankBonus = rankBonusMapper.selectByPrimaryKey(employee.geteRank());
//        employeeCustomVo.setEmployee(employee);
//        employeeCustomVo.setDepartment(department);
//        employeeCustomVo.setPosition(position);
//        employeeCustomVo.setRankBonus(rankBonus);
        return employeeCustomVoMapper.selectEmployeeById(id);
    }

    @Override
    public int updateEmploueeById(int id, Employee employee)  {
        int i = employeeMapper.updateByPrimaryKeySelective(employee);
        if (i == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<Salary> getEmployeeSalaryList(int eId, String year) {
        if ("1".equals(year)){
            return  salaryMapper.selectByeId(eId);
        }else {
                return salaryMapper.selectEmployeeSalaryList(eId,year);
        }
    }
}
