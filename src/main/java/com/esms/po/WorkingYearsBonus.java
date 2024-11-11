package com.esms.po;

public class WorkingYearsBonus {
    private Integer wybId;

    private Integer wybYear;

    private Double wybBonus;

    public Integer getWybId() {
        return wybId;
    }

    public void setWybId(Integer wybId) {
        this.wybId = wybId;
    }

    public Integer getWybYear() {
        return wybYear;
    }

    public void setWybYear(Integer wybYear) {
        this.wybYear = wybYear;
    }

    public Double getWybBonus() {
        return wybBonus;
    }

    public void setWybBonus(Double wybBonus) {
        this.wybBonus = wybBonus;
    }

    @Override
    public String toString() {
        return "WorkingYearsBonus{" +
                "wybId=" + wybId +
                ", wybYear=" + wybYear +
                ", wybBonus=" + wybBonus +
                '}';
    }
}