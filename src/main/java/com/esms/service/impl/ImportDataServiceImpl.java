package com.esms.service.impl;

import com.esms.dao.EmployeeMapper;
import com.esms.dao.MonthlyAttendanceMapper;
import com.esms.dao.SalaryMapper;
import com.esms.po.MonthlyAttendance;
import com.esms.po.Salary;
import com.esms.service.IImportDataService;
import com.esms.utils.JXLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ImportDataServiceImpl implements IImportDataService {
    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper;
    @Autowired
    private SalaryMapper salaryMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    public String insertMATable(MultipartFile excel) throws Exception {
        String fileName = excel.getOriginalFilename();
        //限制上传文件的类型
        if (fileName.endsWith(".xls")) {
            String path = "D://ESMSexcel/monthly_attendance_table/";
            File fileDirectory = new File(path);
            if (!fileDirectory.exists())
                fileDirectory.mkdirs();
            File file = new File(path, fileName);
            //完成上传
            try {
                excel.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<MonthlyAttendance> monthlyAttendanceList = JXLUtils.readMonthlyAttendanceTable(file);

            //校验是否存在员工工号
            for (MonthlyAttendance temp : monthlyAttendanceList) {
                Integer count = employeeMapper.isExistEmployee(temp.getEmployee().geteAccount());
                //如果不存在此员工
                if (count == 0)
                    return "不存在员工工号为" + temp.getEmployee().geteAccount() + "，请检查导入的excel文件";
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            //添加数据到数据库
            for (MonthlyAttendance temp : monthlyAttendanceList) {
                int eId = employeeMapper.selectEidByEaccount(temp.getEmployee().geteAccount());
                temp.getEmployee().seteId(eId);
                MonthlyAttendance mon = new MonthlyAttendance();
                mon = monthlyAttendanceMapper.selectByeIdAndDate(temp.getEmployee().geteId(),dateFormat.format(temp.getAttendanceTime()));
                if(mon ==null) {
                    monthlyAttendanceMapper.insert(temp);
                }
                else{
                    temp.setMaId(mon.getMaId());
                    monthlyAttendanceMapper.updateByPrimaryKeySelective(temp);
                }
            }
            return "导入成功";
        } else {
            return "只能导入Microsoft Excel 97-2003 工作表 (.xls)，请检查文件是否正确";
        }
    }

    public String insertReissueTable(MultipartFile excel) throws Exception {
        String fileName = excel.getOriginalFilename();
        //限制上传文件的类型
        if (fileName.endsWith(".xls")) {
            String path = "D://ESMSexcel/monthly_reissue_table/";
            File fileDirectory = new File(path);
            if (!fileDirectory.exists())
                fileDirectory.mkdirs();
            File file = new File(path, fileName);
            //完成上传
            try {
                excel.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            List<Salary> salaryList = JXLUtils.readReissueTable(file);
            //校验是否存在此员工工号
            for (Salary salary : salaryList) {
                Integer count = employeeMapper.isExistEmployee(salary.getEmployee().geteAccount());
                //如果不存在此员工
                if (count == 0) {
                    return "不存在员工工号为" + salary.getEmployee().geteAccount() + "，请检查导入的excel文件";
                }
            }
            for (Salary salary : salaryList) {
                int eId = employeeMapper.selectEidByEaccount(salary.getEmployee().geteAccount());
                salary.getEmployee().seteId(eId);
                Salary temp = salaryMapper.selectByEidAndTimeAndStatus(salary.getEmployee().geteId(), dateFormat.format(salary.getsTime()),0);
                //如果数据库表salay不存在此记录，直接插入
                if (temp == null) {
                    salary.setBasePay(0.00);
                    salary.setFoodPay(0.00);
                    salary.setPostPay(0.00);
                    salary.setWorkingYearPay(0.00);
                    salary.setRankPay(0.00);
                    salary.setTrafficPay(0.00);
                    salary.setOvertimePay(0.00);
                    salary.setBusinessTravelPay(0.00);
                    salary.setFullAttendancePay(0.00);
//                    salary.setRissuePay(0.00); 表格有

                    salary.setPersionPay(0.00);
                    salary.setMedicalPay(0.00);
                    salary.setUnemploymentPay(0.00);
                    salary.setInjuryPay(0.00);
                    salary.setBirthPay(0.00);
                    salary.setHousingPay(0.00);

                    salary.setLatePay(0.00) ;
                    salary.setEarlyPay(0.00);
                    salary.setSickPay(0.00);
                    salary.setThingPay(0.00);

                    salary.setIndividualIncomeTax(0.00); // 修改个人所得税
                    salary.setShouldPay(0.00); // 修改应发工资
                    salary.setActualPay(0.00); // 修改实发工资

                    salary.setsState(0);
                    salaryMapper.insertSelective(salary);
                } else {
                    //如果数据库表salay已存在此记录，修改补发金额数据
                    salary.setsId(temp.getsId());
                    // shouldPay 应发金额 10项
                    double shouldPay = temp.getBasePay()
                            + temp.getFoodPay()
                            + temp.getPostPay()
                            + temp.getWorkingYearPay()
                            + temp.getRankPay()
                            + temp.getTrafficPay()
                            + temp.getOvertimePay()
                            + temp.getBusinessTravelPay()
                            + temp.getFullAttendancePay()
                            + salary.getRissuePay();

                    // 五险一金扣费 6项
                    double insurances = temp.getPersionPay()
                            + temp.getMedicalPay()
                            + temp.getUnemploymentPay()
                            + temp.getInjuryPay()
                            + temp.getBirthPay()
                            + temp.getHousingPay();

                    // 考勤扣费 4项
                    double attendance = temp.getLatePay()
                            + temp.getEarlyPay()
                            + temp.getSickPay()
                            + temp.getThingPay();

                    double incomeTax = 0;
                    double taxable = shouldPay + insurances + attendance  - temp.getBusinessTravelPay() - 3500; // 纳税超额部分
                    if (0<taxable && taxable <= 1500) {
                        incomeTax = taxable * 0.03;
                    } else if (1500 < taxable && taxable <= 4500) {
                        incomeTax = taxable * 0.1 - 105;
                    } else if (4500 < taxable && taxable <= 9000) {
                        incomeTax = taxable * 0.2 - 555;
                    } else if (9000 < taxable && taxable <= 35000) {
                        incomeTax = taxable * 0.25 - 1005;
                    } else if (35000 < taxable && taxable <= 55000) {
                        incomeTax = taxable * 0.3 - 2755;
                    } else if (55000 < taxable && taxable <= 80000) {
                        incomeTax = taxable * 0.35 - 5505;
                    } else if (80000 < taxable) {
                        incomeTax = taxable * 0.45 - 13505;
                    }
                    salary.setIndividualIncomeTax(-incomeTax); // 修改个人所得税

                    salary.setShouldPay(shouldPay); // 修改应发工资
                    salary.setActualPay(shouldPay + insurances + attendance - incomeTax); // 修改实发工资

                    salaryMapper.updateByPrimaryKeySelective(salary);
                }
            }
        return "导入成功";
    }
        else
            return"只能导入Microsoft Excel 97-2003 工作表 (.xls)，请检查文件是否正确";
}
}
