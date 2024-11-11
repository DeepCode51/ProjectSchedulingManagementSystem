package com.esms.service.impl;

import com.esms.dao.PositionMapper;
import com.esms.po.Position;
import com.esms.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xjx
 * @Date: 2019/10/7 8:27
 */
@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    public PositionMapper positionMapper = null;

    @Override
    public List<Position> findSelective(Position position) {
        return positionMapper.findSelective(position);
    }

    @Override
    public int insertSelective(Position position) {
        return positionMapper.insertSelective(position);
    }

    @Override
    public Position findByPrimaryKey(int id) {
        return positionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKeySelective(Position position) {
        positionMapper.updateByPrimaryKeySelective(position);
    }

    @Override
    public void deleteByPrimaryKey(int id) {
        positionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByQuery(int[] ids) {
        positionMapper.deleteByQuery(ids);
    }

    @Override
    public Position findByDname(String p_name) {
        return positionMapper.findByDname(p_name);
    }


}
