package com.WindowLayOut;

public class AdminPermission {
    Information obj1;
    public AdminPermission(Information obj1)
    {
        this.obj1=obj1;
    }

    public int permission()
    {
        int choice = new InformationShowWindow(obj1).display(1);
        return choice;
    }
}
