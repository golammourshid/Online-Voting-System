package com.WindowLayOut;

import java.io.*;
import java.util.Vector;

public class saveVotingCast {
    Vector<Information> vector;
    saveVotingCast(Vector<Information> vector)
    {
        this.vector = vector;
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(new File("CanditateData\\IsVote.txt")));
            int limit = vector.size();
            for (int i=0;i<limit;i++)
            {
                if (vector.get(i).vote)
                {
                    br.write("1");
                    br.newLine();
                }
                else {
                    br.write("0");
                    br.newLine();
                }
            }
            br.close();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    saveVotingCast(Vector<Information> vector,int type)
    {
        this.vector=vector;
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(new File("CanditateData\\IsVote.txt")));
            int limit = vector.size();
            for (int i=0;i<limit;i++)
            {
                    vector.get(i).vote=false;
                    br.write("0");
                    br.newLine();
            }
            br.close();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }


}
