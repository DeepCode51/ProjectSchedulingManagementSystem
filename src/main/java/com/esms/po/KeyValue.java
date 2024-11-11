package com.esms.po;

public class KeyValue {
    private Integer kvId;

    private String kvKey;

    private double kvValue;

    public Integer getKvId() {
        return kvId;
    }

    public void setKvId(Integer kvId) {
        this.kvId = kvId;
    }

    public String getKvKey() {
        return kvKey;
    }

    public void setKvKey(String kvKey) {
        this.kvKey = kvKey == null ? null : kvKey.trim();
    }

    public double getKvValue() {
        return kvValue;
    }

    public void setKvValue(double kvValue) {
        this.kvValue = kvValue;
    }

    @Override
    public String toString() {
        return "KeyValue{" +
                "kvId=" + kvId +
                ", kvKey='" + kvKey + '\'' +
                ", kvValue='" + kvValue + '\'' +
                '}';
    }
}