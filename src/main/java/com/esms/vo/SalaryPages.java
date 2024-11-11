package com.esms.vo;

import com.esms.po.Salary;

import java.util.List;

/**
 * @program: ssm
 * @Author：方宏泰
 * @Description：
 * @Date：22:07 2019/10/10
 * @Version: 1.0
 */
public class SalaryPages {
    Integer code;
    String msg;
    Integer count;
    List<Salary> data;
    public SalaryPages(){}

    public SalaryPages(Integer code, String msg, Integer count, List<Salary> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
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

    public List<Salary> getData() {
        return data;
    }

    public void setData(List<Salary> data) {
        this.data = data;
    }
}
