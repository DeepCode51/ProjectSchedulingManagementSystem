package com.esms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.esms.exception.CustomException;
import com.esms.service.impl.SalaryServiceImpl;
import com.esms.vo.SalaryPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：23:24 2019/10/9
 * @Version: 1.0
 */
@Controller
public class SalaryController {
    @Autowired
    private SalaryServiceImpl salaryService = null;

    @RequestMapping("salarySettlementByAcount.do")
    @ResponseBody
    public Map<String, String> salarySettlementByAcount(String eAccount, String date) {
        Map<String, String> stringMap = new HashMap<String, String>();
        try {
            salaryService.insertSalaryByAcountAndDate(eAccount, date);
            stringMap.put("msg", "工资结算完成");
            return stringMap;
        } catch (CustomException e) {
            stringMap.put("msg", e.getMessage());
            return stringMap;
        }
    }

    @RequestMapping("salarySettlementAll.do")
    @ResponseBody
    public Map<String, String> salarySettlementAll(String date) {
        Map<String, String> stringMap = new HashMap<String, String>();
        try {
            salaryService.insertSalaryAllByDate(date);
            stringMap.put("msg", "工资结算完成");
            return stringMap;
        } catch (CustomException e) {
            stringMap.put("msg", e.getMessage());
            return stringMap;
        }
    }

    // 删除工资项目
    @RequestMapping("deleteSalaryByEid.do")
    @ResponseBody
    public int deleteSalaryByEid(@RequestParam(value = "arr")int[] ids) {
        salaryService.deleteSalaryByEid(ids);
        return 1;
    }

    // 发放工资项目
    @RequestMapping("issueSalaryByEid.do")
    @ResponseBody
    public void issueSalaryByEid(@RequestParam(value = "arr")int[] ids) {
        salaryService.updateSalaryBySid(ids);
    }

    @RequestMapping(value = "selectSalaryByEaccountDIdDate.do",
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectSalaryByEaccountDIdDate(@RequestParam(value = "page", defaultValue = "1") int pageNum,
                                                @RequestParam(value = "limit", defaultValue = "5") int limit,
                                                String eAccount, Integer dId, String sTime) {
        /**
         * @Author: 方宏泰
         * @Description: 工资查询
         * @Date: 12:37 2019/10/11
         * @Param: [pageNum , limit, eAccount, dId, sTime]
         * @Return: java.lang.String
         **/
        SalaryPages salaryPages = salaryService.selectSalaryByEaccountDIdDate(pageNum, limit, eAccount, dId, sTime);
        //使用fastjson以字符串形式返回数据
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM";
        return JSON.toJSONString(salaryPages, SerializerFeature.WriteDateUseDateFormat);
    }

    @RequestMapping(value = "selectSalaryByEaccountDIdDateState.do",
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectSalaryByEaccountDIdDateState(@RequestParam(value = "page", defaultValue = "1") int pageNum,
                                                @RequestParam(value = "limit", defaultValue = "5") int limit,
                                                String eAccount, Integer dId, String sTime) {
        SalaryPages salaryPages = salaryService.selectSalaryByEaccountDIdDateState(pageNum, limit, eAccount, dId, sTime);
        //使用fastjson以字符串形式返回数据
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM";
        return JSON.toJSONString(salaryPages, SerializerFeature.WriteDateUseDateFormat);
    }

    @RequestMapping(value = "updateSalaryByEidAndRissuePay.do")
    @ResponseBody
    public void updateSalaryByEidAndRissuePay(int sId, double rissuePay) {
        salaryService.updateSalaryByEidAndRissuePay(sId, rissuePay);
    }
}
