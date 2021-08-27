package com.AdminServer;

import com.WindowLayOut.Information;

public class AdminPermission {
    Information obj1;
    AdminPermission(Information obj1)
    {
        this.obj1=obj1;
    }

    public int permission()
    {
        int choice = new InformationShowWindow(obj1).display(1);
        return choice;
    }
}
