package com.esms.vo;

import java.util.List;

/**
 * @Author: xjx
 * @Date: 2019/10/9 16:10
 */
public class MonthlyAttendancePages {
    Integer code;
    String msg;
    Integer count;
    List<MonthlyAttendanceCustomVo> data;

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

    public List<MonthlyAttendanceCustomVo> getData() {
        return data;
    }

    public void setData(List<MonthlyAttendanceCustomVo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MonthlyAttendancePages{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
