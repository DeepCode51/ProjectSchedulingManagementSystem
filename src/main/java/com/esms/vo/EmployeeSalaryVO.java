package com.esms.vo;

import com.esms.po.Salary;

import java.util.List;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：2:06 2019/10/9
 * @Version: 1.0
 */
public class EmployeeSalaryVO {
    Integer code;
    String msg;
    Integer count;
    List<Salary> data;

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

    @Override
    public String toString() {
        return "EmployeeSalaryVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
