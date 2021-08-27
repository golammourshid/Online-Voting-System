package com.WindowLayOut;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MakeEerthingZero {
    MakeEerthingZero()
    {

        try {
            File file = new File("CanditateData\\totalVote.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("0");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i;
        for (i=0;i<3;i++)
        {
            try {
                File file = new File("CanditateData\\Canditate"+i+".txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("0");
                bw.close();

                File file2 = new File("CanditateData\\CanditateVote"+i+".txt");
                BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
                bw2.write("0");
                bw2.newLine();
                bw2.close();

            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
