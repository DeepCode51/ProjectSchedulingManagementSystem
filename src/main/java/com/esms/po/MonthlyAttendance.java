package com.esms.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MonthlyAttendance {
    private Integer maId;

    private Integer eId;
    private Employee employee;

    private Date attendanceTime;

    private Integer sickLeaveNum;

    private Double overtimeHour;

    private Double weekendHour;

    private Double holidayHour;

    private Integer lateNum;

    private Integer earlyNum;

    private Integer absenceNum;

    private Integer businessTravelNum;

    private Integer compassionateLeaveNum;

    public Integer getMaId() {
        return maId;
    }

    public void setMaId(Integer maId) {
        this.maId = maId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public Integer getSickLeaveNum() {
        return sickLeaveNum;
    }

    public void setSickLeaveNum(Integer sickLeaveNum) {
        this.sickLeaveNum = sickLeaveNum;
    }

    public Double getOvertimeHour() {
        return overtimeHour;
    }

    public void setOvertimeHour(Double overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    public Double getWeekendHour() {
        return weekendHour;
    }

    public void setWeekendHour(Double weekendHour) {
        this.weekendHour = weekendHour;
    }

    public Double getHolidayHour() {
        return holidayHour;
    }

    public void setHolidayHour(Double holidayHour) {
        this.holidayHour = holidayHour;
    }

    public Integer getLateNum() {
        return lateNum;
    }

    public void setLateNum(Integer lateNum) {
        this.lateNum = lateNum;
    }

    public Integer getEarlyNum() {
        return earlyNum;
    }

    public void setEarlyNum(Integer earlyNum) {
        this.earlyNum = earlyNum;
    }

    public Integer getAbsenceNum() {
        return absenceNum;
    }

    public void setAbsenceNum(Integer absenceNum) {
        this.absenceNum = absenceNum;
    }

    public Integer getBusinessTravelNum() {
        return businessTravelNum;
    }

    public void setBusinessTravelNum(Integer businessTravelNum) {
        this.businessTravelNum = businessTravelNum;
    }

    public Integer getCompassionateLeaveNum() {
        return compassionateLeaveNum;
    }

    public void setCompassionateLeaveNum(Integer compassionateLeaveNum) {
        this.compassionateLeaveNum = compassionateLeaveNum;
    }

    @Override
    public String toString() {
        return "MonthlyAttendance{" +
                "maId=" + maId +
                ", eId=" + eId +
                ", employee=" + employee +
                ", attendanceTime=" + attendanceTime +
                ", sickLeaveNum=" + sickLeaveNum +
                ", overtimeHour=" + overtimeHour +
                ", weekendHour=" + weekendHour +
                ", holidayHour=" + holidayHour +
                ", lateNum=" + lateNum +
                ", earlyNum=" + earlyNum +
                ", absenceNum=" + absenceNum +
                ", businessTravelNum=" + businessTravelNum +
                ", compassionateLeaveNum=" + compassionateLeaveNum +
                '}';
    }
}