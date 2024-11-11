package com.esms.po;

public class Position {
    private Integer pId;

    private String pName;

    private String pDuty;

    private Double pPostPay;

    private Integer pIsdel;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpDuty() {
        return pDuty;
    }

    public void setpDuty(String pDuty) {
        this.pDuty = pDuty == null ? null : pDuty.trim();
    }

    public Double getpPostPay() {
        return pPostPay;
    }

    public void setpPostPay(Double pPostPay) {
        this.pPostPay = pPostPay;
    }

    public Integer getpIsdel() {
        return pIsdel;
    }

    public void setpIsdel(Integer pIsdel) {
        this.pIsdel = pIsdel;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pDuty='" + pDuty + '\'' +
                ", pPostPay=" + pPostPay +
                ", pIsdel=" + pIsdel +
                '}';
    }
}