package com.esms.vo;

import com.esms.po.RankBonus;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lizefeng
 * Date: 2018-08-09
 * Time: 17:08
 * Projectname:   ssm
 */
public class WokingYearsBonusPages {
    Integer code;
    String msg;
    Integer count;
    List<WokingYearsBonusPages> data;

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

    public List<WokingYearsBonusPages> getData() {
        return data;
    }

    public void setData(List<WokingYearsBonusPages> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WokingYearsBonusPages{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
