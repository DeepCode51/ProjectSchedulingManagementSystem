package com.esms.service.impl;

import com.esms.dao.SalaryMapper;
import com.esms.exception.CustomException;
import com.esms.po.Salary;
import com.esms.service.IDownloadExcelService;
import com.esms.utils.JXLUtils;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssm
 * @Author：方宏泰
 * @Description：
 * @Date：16:26 2019/10/9
 * @Version: 1.0
 */
@Service
public class DownloadExcelServiceImpl implements IDownloadExcelService{
    @Autowired
    private SalaryMapper salaryMapper;
    @Override
    public void getSalaryExcel(HttpServletRequest request, HttpServletResponse response,String eAccount,Integer dId,String sTime)  throws Exception{
       // response.setCharacterEncoding("utf-8");
        //response.setHeader("Content-Disposition", "text/html; charset=utf-8;attachment; filename=salary.xls");
        String excelName = "工资表.xls";
            //WritableWorkbook writableWorkbook = ExcelUtils.createTemplate(response.getOutputStream());

        WritableWorkbook writableWorkbook = null;
        Map map = new HashMap<String,Object>();
        map.put("eAccount",eAccount);
        map.put("dId",dId);
        map.put("sTime",sTime);
        List<Salary> salaries = salaryMapper.selectByEaccountDIdDate(map);
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName.getBytes("gbk"),"ISO-8859-1"));
            writableWorkbook = JXLUtils.createSalaryExcel(response.getOutputStream(),salaries);
            writableWorkbook.write();
            writableWorkbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException("下载失败");
        } catch (WriteException e) {
            e.printStackTrace();
            throw new CustomException("下载失败");
        }
        }


}
