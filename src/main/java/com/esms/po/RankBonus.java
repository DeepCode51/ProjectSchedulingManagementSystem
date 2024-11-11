package com.esms.po;

public class RankBonus {
    private Integer rbId;

    private String rankName;

    private Integer rbBonus;

    public Integer getRbId() {
        return rbId;
    }

    public void setRbId(Integer rbId) {
        this.rbId = rbId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName == null ? null : rankName.trim();
    }

    public Integer getRbBonus() {
        return rbBonus;
    }

    public void setRbBonus(Integer rbBonus) {
        this.rbBonus = rbBonus;
    }

    @Override
    public String toString() {
        return "RankBonus{" +
                "rbId=" + rbId +
                ", rankName='" + rankName + '\'' +
                ", rbBonus=" + rbBonus +
                '}';
    }
}