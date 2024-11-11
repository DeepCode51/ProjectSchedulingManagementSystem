package com.esms.service;

import com.esms.exception.CustomException;
import jxl.write.WriteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IDownloadExcelService {
    void getSalaryExcel(HttpServletRequest request, HttpServletResponse response,String eAccount,Integer dId,String sTime) throws Exception;
}
