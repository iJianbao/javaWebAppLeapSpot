package com.smart.domain;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;

    public int getLoginLogId() {
        return loginLogId;
    }
    public void setLoginLogId(int value) {
        loginLogId = value;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int value) {
        userId = value;
    }

    public String getIp() {
        return ip;
    }
    public void setIp(String value) {
        ip = value;
    }

    public Date getLoginDate() {
        return loginDate;
    }
    public void setLoginDate(Date value) {
        loginDate = value;
    }
}
