package com.esms.dao;

import com.esms.vo.EmployeeCustomVo;

import java.util.HashMap;
import java.util.List;

public interface EmployeeCustomVoMapper {
    public EmployeeCustomVo selectEmployeeById(int eId);

    List<EmployeeCustomVo> selectEmployeeSelective(HashMap<String, Object> map);

    EmployeeCustomVo selectVoByPrimaryKey(int id);
}
