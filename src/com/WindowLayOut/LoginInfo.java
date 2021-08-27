package com.WindowLayOut;

public class LoginInfo {
    String UserName;
    String RegNo;

    LoginInfo(String UserName,String regNo)
    {
        this.UserName = UserName;
        this.RegNo = regNo;
    }
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }
}
