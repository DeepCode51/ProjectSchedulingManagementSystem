package com.esms.controller;

import com.esms.service.IEchartsService;
import com.esms.service.impl.EchartsServiceImpl;
import com.esms.vo.EchDepartmentSalary;
import com.esms.vo.EchEmployeeNums;
import com.esms.vo.EchMonthSalary;
import com.esms.vo.EchSalaryPercent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @Author: 方宏泰
 * @Description: 图表制作类
 * @Date: 22:24 2019/10/6
 **/
@Controller
public class EchartsController {
    @Autowired
    private IEchartsService echartsService;

    @RequestMapping(value = "/showEmployeeNums.do")
    @ResponseBody
    public Map<String,List<EchEmployeeNums>> showEmployeeNums(){
        /**
         * 各部门的员工数量柱状图的数据
         * json格式{"list":[{"department":"人事部","num":480},{"department":"行政部","num":380}]}
         */
        /*
        List<EchEmployeeNums> echEmployeeNumsList = new ArrayList();
        Map<String,List<EchEmployeeNums>> map = new HashMap<String,List<EchEmployeeNums>>();
        EchEmployeeNums e1 = new EchEmployeeNums();
        e1.setDepartment("人事部");
        e1.setNum(123);
        EchEmployeeNums e2 = new EchEmployeeNums();
        e2.setDepartment("行政部");
        e2.setNum(123);
        echEmployeeNumsList.add(e1);
        echEmployeeNumsList.add(e2);
        map.put("list",echEmployeeNumsList);*/
        return echartsService.getEmployeeNums();
    }

    @RequestMapping(value = "/showDepartmentSalary.do")
    @ResponseBody
    public Map<String,List<EchDepartmentSalary>> showDepartmentSalary(String date){
        /**
         *各年月工资对比图的数据
         * json格式{"list":[{"year":"1","salary":[480,500,600,..]},{"year":"2","salary":[480,500,600...]}]}
         */
/*
        List<EchDepartmentSalary> echDepartmentSalaryList = new ArrayList<EchDepartmentSalary>();
        Map<String,List<EchDepartmentSalary>> stringListMap = new HashMap<String, List<EchDepartmentSalary>>();

        EchDepartmentSalary e1 = new EchDepartmentSalary();
        e1.setDepartment("人事部");
        List<Double> salary1 = new ArrayList<Double>();
        salary1.add(5000.00);
        salary1.add(8000.00);
        salary1.add(20000.00);
        e1.setSalary(salary1);

        EchDepartmentSalary e2 = new EchDepartmentSalary();
        e2.setDepartment("科研部");
        List<Double> salary2 = new ArrayList<Double>();
        salary2.add(6000.00);
        salary2.add(8500.00);
        salary2.add(25000.00);
        e2.setSalary(salary2);

        EchDepartmentSalary e3 = new EchDepartmentSalary();
        e3.setDepartment("策划部");
        List<Double> salary3 = new ArrayList<Double>();
        salary3.add(6000.00);
        salary3.add(8800.00);
        salary3.add(23000.00);
        e3.setSalary(salary3);

        echDepartmentSalaryList.add(e1);
        echDepartmentSalaryList.add(e2);
        echDepartmentSalaryList.add(e3);
        stringListMap.put("list",echDepartmentSalaryList);
        return stringListMap;*/
        return echartsService.getDepartmentSalary(date);
    }

    @RequestMapping(value = "/showSalaryPercent.do")
    @ResponseBody
    public Map<String,List<EchSalaryPercent>> showSalaryPercent(String date,int state){
        /*List<EchSalaryPercent> echSalaryPercentList = new ArrayList<EchSalaryPercent>();
        Map<String,List<EchSalaryPercent>> map = new HashMap<String,List<EchSalaryPercent>>();
        EchSalaryPercent s1 = new EchSalaryPercent();
        EchSalaryPercent s2 = new EchSalaryPercent();
        s1.setDepartment("人事部");
        s1.setSalary(1010010.00);
        s2.setDepartment("科研部");
        s2.setSalary(1510010.00);
        echSalaryPercentList.add(s1);
        echSalaryPercentList.add(s2);
        map.put("list",echSalaryPercentList);*/

        return  echartsService.getSalaryPercent(date,state);
    }

    @RequestMapping(value = "/showMonthSalary.do")
    @ResponseBody
    public Map<String,List<EchMonthSalary>> showMonthSalary(){
        /*
        List<EchMonthSalary> echMonthSalaryList = new ArrayList<EchMonthSalary>();
        Map<String,List<EchMonthSalary>> stringListMap = new HashMap<String, List<EchMonthSalary>>();

        EchMonthSalary e1 = new EchMonthSalary();
        e1.setYear("2015年");
        List<Double> salary1 = new ArrayList<Double>();
        salary1.add(5000.00);
        salary1.add(8000.00);
        salary1.add(20000.00);
        salary1.add(5000.00);
        salary1.add(8000.00);
        salary1.add(20000.00);
        salary1.add(5000.00);
        salary1.add(8000.00);
        salary1.add(20000.00);
        salary1.add(5000.00);
        salary1.add(8000.00);
        salary1.add(20000.00);
        e1.setSalary(salary1);

        EchMonthSalary e2 = new EchMonthSalary();
        e2.setYear("2016年");
        List<Double> salary2 = new ArrayList<Double>();
        salary2.add(5800.00);
        salary2.add(8080.00);
        salary2.add(20800.00);
        salary2.add(5080.00);
        salary2.add(8800.00);
        salary2.add(20800.00);
        salary2.add(5080.00);
        salary2.add(8080.00);
        salary2.add(20800.00);
        salary2.add(5080.00);
        salary2.add(8080.00);
        salary2.add(20080.00);
        e2.setSalary(salary2);

        EchMonthSalary e3 = new EchMonthSalary();
        e3.setYear("2017年");
        List<Double> salary3 = new ArrayList<Double>();
        salary3.add(6000.00);
        salary3.add(8800.00);
        salary3.add(23000.00);
        salary3.add(6000.00);
        salary3.add(8800.00);
        salary3.add(23000.00);
        salary3.add(6000.00);
        salary3.add(8800.00);
        salary3.add(23000.00);
        salary3.add(6000.00);
        salary3.add(8800.00);
        salary3.add(23000.00);
        e3.setSalary(salary3);

        echMonthSalaryList.add(e1);
        echMonthSalaryList.add(e2);
        echMonthSalaryList.add(e3);
        stringListMap.put("list",echMonthSalaryList);
        return stringListMap;*/
        return echartsService.getMonthSalary();
    }

}
