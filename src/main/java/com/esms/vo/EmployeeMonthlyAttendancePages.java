package com.esms.vo;

import com.esms.po.MonthlyAttendance;

import java.util.List;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：21:26 2019/10/14
 * @Version: 1.0
 */
public class EmployeeMonthlyAttendancePages {
    Integer code;
    String msg;
    Integer count;
    List<MonthlyAttendance> data;

    @Override
    public String toString() {
        return "EmployeeMonthlyAttendancePages{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<MonthlyAttendance> getData() {
        return data;
    }

    public void setData(List<MonthlyAttendance> data) {
        this.data = data;
    }
}
