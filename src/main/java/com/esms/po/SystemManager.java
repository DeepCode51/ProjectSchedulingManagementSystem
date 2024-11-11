package com.esms.po;

public class SystemManager {
    private Integer smId;

    private String smAccount;

    private String smPassword;

    public Integer getSmId() {
        return smId;
    }

    public void setSmId(Integer smId) {
        this.smId = smId;
    }

    public String getSmAccount() {
        return smAccount;
    }

    public void setSmAccount(String smAccount) {
        this.smAccount = smAccount == null ? null : smAccount.trim();
    }

    public String getSmPassword() {
        return smPassword;
    }

    public void setSmPassword(String smPassword) {
        this.smPassword = smPassword == null ? null : smPassword.trim();
    }

    @Override
    public String toString() {
        return "SystemManager{" +
                "smId=" + smId +
                ", smAccount='" + smAccount + '\'' +
                ", smPassword='" + smPassword + '\'' +
                '}';
    }
}