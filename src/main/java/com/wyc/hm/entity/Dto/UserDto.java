package com.wyc.hm.entity.Dto;

import com.wyc.hm.entity.User;

import java.util.Date;

public class UserDto extends User {
    private Date dkTime;
    private String date;

    public Date getDkTime() {
        return dkTime;
    }

    public void setDkTime(Date dkTime) {
        this.dkTime = dkTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
