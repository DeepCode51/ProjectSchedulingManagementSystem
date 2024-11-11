package com.esms.vo;

import java.util.List;

/**
 * @Author: xjx
 * @Date: 2019/10/10 15:24
 */
public class EmployeePages {
    Integer code;
    String msg;
    Integer count;
    List<EmployeeCustomVo> data;

    @Override
    public String toString() {
        return "EmployeePages{" +
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

    public List<EmployeeCustomVo> getData() {
        return data;
    }

    public void setData(List<EmployeeCustomVo> data) {
        this.data = data;
    }
}
