package com.esms.vo;

import com.esms.po.Department;

import java.util.List;

/**
 * @Author: xjx
 * @Date: 2019/10/7 22:47
 */
public class DepartmentPages {
    Integer code;
    String msg;
    Integer count;
    List<Department> data;

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

    public List<Department> getData() {
        return data;
    }

    public void setData(List<Department> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DepartmentPages{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
