package com.esms.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Employee {
    private Integer eId;

    private String eAccount;

    private String ePassword;

    private String eName;

    private String eIdcard;

    private String  eSex;

    private String eDagree;

    private Date eBirthday;

    private String eEmail;

    private String ePhone;

    private String eHometown;

    private Integer eRank;
//    private RankBonus rankBonus;

    private String eHeadPath;

    private String eUrgentPerson;

    private String eUrgentPhone;

    private Integer pId;
//    private Position position;
    private Integer dId;
//    private Department department;

    private Double eBasePay;

    private Integer eIsdel;

    private Date eEntryTime;

    private Date eLeaveTime;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteAccount() {
        return eAccount;
    }

    public void seteAccount(String eAccount) {
        this.eAccount = eAccount == null ? null : eAccount.trim();
    }

    public String getePassword() {
        return ePassword;
    }

    public void setePassword(String ePassword) {
        this.ePassword = ePassword == null ? null : ePassword.trim();
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String geteIdcard() {
        return eIdcard;
    }

    public void seteIdcard(String eIdcard) {
        this.eIdcard = eIdcard == null ? null : eIdcard.trim();
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    public String geteDagree() {
        return eDagree;
    }

    public void seteDagree(String eDagree) {
        this.eDagree = eDagree == null ? null : eDagree.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date geteBirthday() {
        return eBirthday;
    }

    public void seteBirthday(Date eBirthday) {
        this.eBirthday = eBirthday;
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail == null ? null : eEmail.trim();
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone == null ? null : ePhone.trim();
    }

    public String geteHometown() {
        return eHometown;
    }

    public void seteHometown(String eHometown) {
        this.eHometown = eHometown == null ? null : eHometown.trim();
    }

    public Integer geteRank() {
        return eRank;
    }

    public void seteRank(Integer eRank) {
        this.eRank = eRank;
    }

    public String geteHeadPath() {
        return eHeadPath;
    }

    public void seteHeadPath(String eHeadPath) {
        this.eHeadPath = eHeadPath == null ? null : eHeadPath.trim();
    }

    public String geteUrgentPerson() {
        return eUrgentPerson;
    }

    public void seteUrgentPerson(String eUrgentPerson) {
        this.eUrgentPerson = eUrgentPerson == null ? null : eUrgentPerson.trim();
    }

    public String geteUrgentPhone() {
        return eUrgentPhone;
    }

    public void seteUrgentPhone(String eUrgentPhone) {
        this.eUrgentPhone = eUrgentPhone == null ? null : eUrgentPhone.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

//    public RankBonus getRankBonus() {
//        return rankBonus;
//    }
//
//    public void setRankBonus(RankBonus rankBonus) {
//        this.rankBonus = rankBonus;
//    }
//
//    public Position getPosition() {
//        return position;
//    }
//
//    public void setPosition(Position position) {
//        this.position = position;
//    }
//
//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }

    public Double geteBasePay() {
        return eBasePay;
    }

    public void seteBasePay(Double eBasePay) {
        this.eBasePay = eBasePay;
    }

    public Integer geteIsdel() {
        return eIsdel;
    }

    public void seteIsdel(Integer eIsdel) {
        this.eIsdel = eIsdel;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date geteEntryTime() {
        return eEntryTime;
    }

    public void seteEntryTime(Date eEntryTime) {
        this.eEntryTime = eEntryTime;
    }

    public Date geteLeaveTime() {
        return eLeaveTime;
    }

    public void seteLeaveTime(Date eLeaveTime) {
        this.eLeaveTime = eLeaveTime;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", eAccount='" + eAccount + '\'' +
                ", ePassword='" + ePassword + '\'' +
                ", eName='" + eName + '\'' +
                ", eIdcard='" + eIdcard + '\'' +
                ", eSex=" + eSex +
                ", eDagree='" + eDagree + '\'' +
                ", eBirthday=" + eBirthday +
                ", eEmail='" + eEmail + '\'' +
                ", ePhone='" + ePhone + '\'' +
                ", eHometown='" + eHometown + '\'' +
                ", eRank=" + eRank +
                ", eHeadPath='" + eHeadPath + '\'' +
                ", eUrgentPerson='" + eUrgentPerson + '\'' +
                ", eUrgentPhone='" + eUrgentPhone + '\'' +
                ", pId=" + pId +
                ", dId=" + dId +
                ", eBasePay=" + eBasePay +
                ", eIsdel=" + eIsdel +
                ", eEntryTime=" + eEntryTime +
                ", eLeaveTime=" + eLeaveTime +
                '}';
    }
}