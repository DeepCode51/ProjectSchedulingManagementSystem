package com.esms.dao;

import com.esms.po.RankBonus;

import java.util.List;

public interface RankBonusMapper {
    int deleteByPrimaryKey(Integer rbId);

    int insert(RankBonus record);

    int insertSelective(RankBonus record);

    RankBonus selectByPrimaryKey(Integer rbId);

    List<RankBonus> selectAll();

    int updateByPrimaryKeySelective(RankBonus record);

    int updateByPrimaryKey(RankBonus record);

    int CountByRankName(String name);

    List<RankBonus> findSelective(RankBonus record);

    RankBonus findByname(String name);
}