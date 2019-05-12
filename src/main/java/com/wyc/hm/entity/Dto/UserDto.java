package com.wyc.hm.entity.Dto;

import com.wyc.hm.entity.User;

import java.util.Date;

public class UserDto extends User {
    private Date dkTime;

    public Date getDkTime() {
        return dkTime;
    }

    public void setDkTime(Date dkTime) {
        this.dkTime = dkTime;
    }

}
