package com.esms.controller;

import com.esms.dao.MonthlyAttendanceCustomVoMapper;
import com.esms.dao.MonthlyAttendanceMapper;
import com.esms.po.MonthlyAttendance;
import com.esms.service.impl.MonthlyAttendanceServiceImpl;
import com.esms.vo.EmployeeMonthlyAttendancePages;
import com.esms.vo.MonthlyAttendanceCustomVo;
import com.esms.vo.MonthlyAttendancePages;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: xjx
 * @Date: 2019/10/9 8:08
 */
@Controller
@RequestMapping("/monthlyattendance")
public class MonthlyAttendanceController{
    @Autowired
    private MonthlyAttendanceServiceImpl monthlyAttendanceService;

    @Autowired
    private MonthlyAttendanceCustomVoMapper monthlyAttendanceCustomVoMapper = null;

    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper = null;

    @RequestMapping("test.do")
    @ResponseBody
    public List<MonthlyAttendanceCustomVo> test(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("e_account","4");
        map.put("d_id",4);
        map.put("attendance_time","2017-08");
        List<MonthlyAttendanceCustomVo> monthlyAttendanceCustomVos =
                monthlyAttendanceCustomVoMapper.selectMonthlyAttendanceCustomVoMapperByeAccountAnddIdAndTime(map);
        return monthlyAttendanceCustomVos;
    }


    /**
     * 查找
     * @param pageNum
     * @param limit
     * @param e_account
     * @param d_id
     * @param attendance_time
     * @return
     * @throws Exception
     */
    @RequestMapping("/findSelective.do")
    @ResponseBody
    public MonthlyAttendancePages findSelective(
            @RequestParam(value="page", defaultValue="1")int pageNum,
            @RequestParam(value="limit", defaultValue="5") int limit,
            @RequestParam(value="e_account", defaultValue="") String e_account,
            @RequestParam(value="d_id", defaultValue="0") int d_id,
            @RequestParam(value="attendance_time", defaultValue="") String attendance_time) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("e_account",e_account);
        map.put("d_id",d_id);
        map.put("attendance_time",attendance_time);
        //pageNum:起始页面  pageSize:每页的大小
        PageHelper.startPage(pageNum,limit);
        //查找条件，一定要紧跟在startPage后
        List<MonthlyAttendanceCustomVo> list =
                monthlyAttendanceCustomVoMapper.selectMonthlyAttendanceCustomVoMapperByeAccountAnddIdAndTime(map);
//        System.out.println(list.get(0).getMonthlyAttendance().getAttendanceTime()+"========================");
        PageInfo pageResult = new PageInfo(list);

        //设置前台需要的数据
        MonthlyAttendancePages monthlyAttendancePages = new MonthlyAttendancePages();
        monthlyAttendancePages.setCode(0);
        monthlyAttendancePages.setMsg("");
        monthlyAttendancePages.setCount((int) pageResult.getTotal());
        monthlyAttendancePages.setData(pageResult.getList());
        return monthlyAttendancePages;
    }

    /**
     * 查找一个
     * @param id
     * @return
     */
    @RequestMapping("/selectVoByPrimaryKey.do")
    @ResponseBody
    public MonthlyAttendanceCustomVo selectVoByPrimaryKey(int id) {
        MonthlyAttendanceCustomVo monthlyAttendanceCustomVo = new MonthlyAttendanceCustomVo();
        monthlyAttendanceCustomVo = monthlyAttendanceCustomVoMapper.selectVoByPrimaryKey(id);
//        System.out.println(monthlyAttendanceCustomVo+"=======================");
        return monthlyAttendanceCustomVo;
    }

    /**
     * 更新
     * @param maId
     * @param sickLeaveNum
     * @param compassionateLeaveNum
     * @param overtimeHour
     * @param weekendHour
     * @param holidayHour
     * @param lateNum
     * @param earlyNum
     * @param absenceNum
     * @param businessTravelNum
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateByPrimaryKeySelective.do")
    @ResponseBody
    public int updateByPrimaryKeySelective(int maId,
                                  int sickLeaveNum,
                                  int compassionateLeaveNum,
                                  double overtimeHour,
                                  double weekendHour,
                                  double holidayHour,
                                  int lateNum,
                                  int earlyNum,
                                  int absenceNum,
                                  int businessTravelNum
                                  ) throws Exception {
        MonthlyAttendance monthlyAttendance = new MonthlyAttendance();
        monthlyAttendance.setMaId(maId);
        monthlyAttendance.setSickLeaveNum(sickLeaveNum);
        monthlyAttendance.setCompassionateLeaveNum(compassionateLeaveNum);
        monthlyAttendance.setOvertimeHour(overtimeHour);
        monthlyAttendance.setWeekendHour(weekendHour);
        monthlyAttendance.setHolidayHour(holidayHour);
        monthlyAttendance.setLateNum(lateNum);
        monthlyAttendance.setEarlyNum(earlyNum);
        monthlyAttendance.setAbsenceNum(absenceNum);
        monthlyAttendance.setBusinessTravelNum(businessTravelNum);
//        System.out.println(monthlyAttendance+"======================================================");
        monthlyAttendanceService.updateByPrimaryKeySelective(monthlyAttendance);
        return 1;
    }

    /**
     * 删除
     * @param id
     * @throws Exception
     */
    @RequestMapping("/deleteByPrimaryKey.do")
    @ResponseBody
    public int deleteByPrimaryKey(int id) throws Exception {
        //真删除
        MonthlyAttendance monthlyAttendance = new MonthlyAttendance();
        monthlyAttendance.setMaId(id);
        monthlyAttendanceService.deleteByPrimaryKey(id);
        return 1;
    }

    /**
     * 批量删除
     * @param ids
     */
    @RequestMapping("/deleteByQuery.do")
    @ResponseBody
    public int deleteByQuery (@RequestParam(value = "arr")int[] ids) {

//        for (int i =0 ; i< ids.length;i++) {
//            System.out.println(ids[i]);
//        }
        //真删除
        //如果有id才执行
        if(ids.length > 0) {
            monthlyAttendanceService.deleteByQuery(ids);
        }
        return 1;

    }

    @RequestMapping("/findEmployeeAttendance.do")
    @ResponseBody
    public EmployeeMonthlyAttendancePages findEmployeeAttendance(
            @RequestParam(value="page", defaultValue="1")int pageNum,
            @RequestParam(value="limit", defaultValue="5") int limit,
            @RequestParam(value="attendance_time", defaultValue="") String attendance_time,
            HttpSession httpSession) throws Exception {
        Integer id = (Integer) httpSession.getAttribute("employeeId");
        //pageNum:起始页面  pageSize:每页的大小
        PageHelper.startPage(pageNum,limit);
        //查找条件，一定要紧跟在startPage后
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("e_id",id);
        map.put("attendance_time",attendance_time);
        List<MonthlyAttendance> list = monthlyAttendanceMapper.selectMonthlyAttendanceMapperByeEidAndTime(map);
        PageInfo pageResult = new PageInfo(list);

        //设置前台需要的数据
        EmployeeMonthlyAttendancePages employeeMonthlyAttendancePages = new EmployeeMonthlyAttendancePages();
        employeeMonthlyAttendancePages.setCode(0);
        employeeMonthlyAttendancePages.setMsg("");
        employeeMonthlyAttendancePages.setCount((int) pageResult.getTotal());
        employeeMonthlyAttendancePages.setData(pageResult.getList());
        return employeeMonthlyAttendancePages;
    }
}
