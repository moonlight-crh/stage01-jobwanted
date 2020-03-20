package com.crh.entity;

import java.util.Date;

public class SysUsr {
    private Integer pkId;

    private String userName;

    private String password;

    private String remark;

    private Date inputTime;

    private Date updateTime;

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SysUsr{" +
                "pkId=" + pkId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                ", inputTime=" + inputTime +
                ", updateTime=" + updateTime +
                '}';
    }
}