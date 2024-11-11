package com.esms.service;

import com.esms.po.Department;

import java.util.List;

public interface DepartmentService {
    public Department selectByPrimaryKey(int id) throws Exception;

    int insertSelective(Department department) throws Exception;

    void updateByPrimaryKeySelective(Department department) throws Exception;

    void deleteByPrimaryKey(int id) throws Exception;

    List<Department> findSelective(Department department) throws Exception;

    void deleteByQuery(int[] ids);

    Department findByDname(String d_name);
}
