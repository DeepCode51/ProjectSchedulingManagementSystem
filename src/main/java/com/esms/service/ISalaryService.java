package com.esms.service;

import com.esms.exception.CustomException;
import com.esms.vo.SalaryPages;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：23:23 2019/10/9
 * @Version: 1.0
 */
public interface ISalaryService {
    public void insertSalaryByAcountAndDate(String eAccount, String date) throws CustomException;
    public void insertSalaryAllByDate(String date) throws CustomException;
    public SalaryPages selectSalaryByEaccountDIdDate(Integer pageNum,Integer limit,String eAccount,Integer dId,String sTime);
    public void deleteSalaryByEid(int[] ids);
    public void updateSalaryBySid(int[] ids);

    public  SalaryPages selectSalaryByEaccountDIdDateState(int pageNum, int limit, String eAccount, Integer dId, String sTime);

    void updateSalaryByEidAndRissuePay(int sId, double rissuePay);
}
