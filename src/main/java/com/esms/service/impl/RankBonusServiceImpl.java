package com.esms.service.impl;

import com.esms.dao.EmployeeMapper;
import com.esms.dao.RankBonusMapper;
import com.esms.dao.WorkingYearsBonusMapper;
import com.esms.po.RankBonus;
import com.esms.service.IRankBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lizefeng
 * Date: 2018-08-06
 * Time: 10:45
 * Projectname:   ssm
 */
@Service("rankBonusService")
public class RankBonusServiceImpl implements IRankBonusService {
    @Autowired
    private RankBonusMapper rankBonusMapper;
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public int CountByRbid(Integer rbid) {
        int n=employeeMapper.countByRbid(rbid);
        if(n>0) return n;
        else return 0;
    }



    public void setRankBonusMapper(RankBonusMapper rankBonusMapper) {
        this.rankBonusMapper = rankBonusMapper;
    }
    @Override
    public boolean moveRankBonus(int rbId) {
        int n=rankBonusMapper.deleteByPrimaryKey(rbId);
        if(n>0){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean modifyRankName(RankBonus rb) {
        int n=rankBonusMapper.updateByPrimaryKey(rb);
        if(n>0)
            return true;
        else
            return false;
    }

    @Override
    public List<RankBonus> findAll() {

        List<RankBonus> rb = rankBonusMapper.selectAll();
        if(rb.size()>0){
            return rb;
        }
        else{
            return null;
        }
    }

    @Override
    public RankBonus findById(int rbId) {
        return null;
    }

    @Override
    public RankBonus findByName(String rankName) {
        return  rankBonusMapper.findByname(rankName);
    }

    @Override
    public boolean addRankBonus(RankBonus rb) {
        int count = rankBonusMapper.insert(rb);
        if (count > 0) {
            return true;
        }
        return false;
    }

    public int CountByRbid(int rbId){
        int count =employeeMapper.countByRbid(rbId);
        if(count>0){ return count; }
        else{ return 0; }
    }

    @Override
    public int CountByName(String name) {
        int count=rankBonusMapper.CountByRankName(name);
        if(count>0) return count;
        else return 0;
    }

    @Override
    public List<RankBonus> findSelective(RankBonus rb)  {
        return rankBonusMapper.findSelective(rb);
    }
}
