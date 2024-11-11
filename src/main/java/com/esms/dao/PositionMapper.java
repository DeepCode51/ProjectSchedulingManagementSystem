package com.esms.dao;

import com.esms.po.Position;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> findSelective(Position position);

    void deleteByQuery(int[] ids);

    Position findByDname(String p_name);
}