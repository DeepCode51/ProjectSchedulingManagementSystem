package com.esms.controller;

import com.esms.exception.CustomException;
import com.esms.service.IDownloadExcelService;
import com.esms.service.impl.DownloadExcelServiceImpl;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: ssm
 * @Author：方宏泰
 * @Description：下载excel表格
 * @Date：16:20 2019/10/9
 * @Version: 1.0
 */
@Controller
public class DownloadExcelController {
    @Autowired
    private IDownloadExcelService downloadExcelService;

    @RequestMapping(value = "downloadExcel.do")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response,String eAccount,Integer dId,String sTime)  throws Exception{
        downloadExcelService.getSalaryExcel(request,response,eAccount,dId,sTime) ;
    }
}
