package com.smart.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "myTest.t_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "用户id不能为空")
    private int userId;

    @Column(name = "user_name")
    @NotNull(message = "用户名不能为空")
    @Pattern(regexp = "^[a-zA-Z_]\\w{4,19}$", message = "用户名必须以字母下划线开头，可由字母数字下划线组成")
    private String userName;

    @Column(name = "password")
    @NotNull(message = "密码不能为空")
    @Pattern(regexp = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,20}$", message = "密码必须包含小写字母、大小字母及数字")
    private String password;

    @Column(name = "last_ip")
    private String lastIp;

    @Column(name = "last_visit")
    @Past
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date lastVisit;

    public int getUserId() {
        return userId;
    }
    public void setUserId(int value) {
        userId = value;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String value) {
        userName = value;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String value) {
        password = value;
    }

    public String getLastIp() {
        return lastIp;
    }
    public void setLastIp(String value) {
        lastIp = value;
    }

    public Date getLastVisit() {
        return lastVisit;
    }
    public void setLastVisit(Date value) {
        lastVisit = value;
    }
}
