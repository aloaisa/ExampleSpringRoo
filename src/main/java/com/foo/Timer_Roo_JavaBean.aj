// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.foo;

import java.lang.String;
import java.util.Date;

privileged aspect Timer_Roo_JavaBean {
    
    public String Timer.getUserName() {
        return this.userName;
    }
    
    public void Timer.setUserName(String userName) {
        this.userName = userName;
    }
    
    public Date Timer.getStartDate() {
        return this.startDate;
    }
    
    public void Timer.setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
}