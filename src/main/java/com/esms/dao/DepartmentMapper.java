package com.esms.dao;

import com.esms.po.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer dId);

    List<Department> selectAll();

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> findSelective(Department department);

    void deleteByQuery(int[] ids);

    Department findByDname(String d_name);
}