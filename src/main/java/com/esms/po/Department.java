package com.esms.po;

public class Department {
    private Integer dId;

    private String dName;

    private String dRemark;

    private Integer dIsdel;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public String getdRemark() {
        return dRemark;
    }

    public void setdRemark(String dRemark) {
        this.dRemark = dRemark == null ? null : dRemark.trim();
    }

    public Integer getdIsdel() {
        return dIsdel;
    }

    public void setdIsdel(Integer dIsdel) {
        this.dIsdel = dIsdel;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dRemark='" + dRemark + '\'' +
                ", dIsdel=" + dIsdel +
                '}';
    }
}