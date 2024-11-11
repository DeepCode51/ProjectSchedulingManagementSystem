package com.esms.service.impl;
import com.esms.dao.WorkingYearsBonusMapper;
import com.esms.po.WorkingYearsBonus;
import com.esms.service.IWorkYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lizefeng
 * Date: 2018-08-06
 * Time: 10:45
 * Projectname:   ssm
 */
@Service
public class WorkYearServiceImpl implements IWorkYearService {
    @Autowired
    private WorkingYearsBonusMapper workingYearsBonusMapper;

    @Override
    public boolean addWorkYearBonus(WorkingYearsBonus wyb) {
        int count = workingYearsBonusMapper.insert(wyb);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean moveWorkYearBonus(int wybId) {
        int n=workingYearsBonusMapper.deleteByPrimaryKey(wybId);
        if(n>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean modifyWorkYearBonus(WorkingYearsBonus wyb) {
        int n=workingYearsBonusMapper.updateByPrimaryKey(wyb);
        if(n>0)
            return true;
        else
            return false;
    }

    @Override
    public List<WorkingYearsBonus> findAll() {
        List<WorkingYearsBonus> wyb = workingYearsBonusMapper.selectAll();
        if(wyb.size()>0){
            return wyb;
        }
        else{
            return null;
        }
    }

    @Override
    public WorkingYearsBonus findById(int wybId) {
        return null;
    }

    @Override
    public int Count(int wybYear) {
        int n=workingYearsBonusMapper.countByYear(wybYear);
        if(n>0) return n;
        else return 0;
    }

    @Override
    public List<WorkingYearsBonus> findSelective(WorkingYearsBonus record) {
        return workingYearsBonusMapper.findSelective(record);
    }

    @Override
    public WorkingYearsBonus findByYear(int year) {
        return workingYearsBonusMapper.findByYear(year);
    }
}
