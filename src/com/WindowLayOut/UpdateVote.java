package com.WindowLayOut;

public class UpdateVote {
    CanditateData data1;
    String info;
    UpdateVote(String ss,CanditateData data1)
    {
        this.data1=data1;
        this.info=ss;
        if (data1.total[0]!=0)
        {
            char temp = info.charAt(5);
            int pos = temp-49;
            data1.vote1[pos]+=1;
        }
        if (data1.total[1]!=0)
        {
            char temp = info.charAt(11);
            int pos = temp-49;
            data1.vote2[pos]+=1;
        }
        if (data1.total[2]!=0)
        {
            char temp = info.charAt(17);
            int pos = temp-49;
            data1.vote3[pos]+=1;
        }
    }
    public boolean methd()
    {
        return true;
    }
}
