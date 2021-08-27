package com.WindowLayOut;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveVote {
    CanditateData data1;
    public SaveVote(CanditateData data1) {
        this.data1 = data1;

        try {
            File file2 = new File("CanditateData\\totalVote.txt");
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
            bw2.write(String.valueOf(data1.totalVote));
            bw2.newLine();
            bw2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i=0;i<3;i++)
        {
            if (data1.total[i]!=0)
            {
                try {
                    File file2 = new File("CanditateData\\CanditateVote"+i+".txt");
                    BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
                    bw2.write(String.valueOf(data1.total[i]));
                    bw2.newLine();
                    for (int j=0;j<data1.total[i];j++)
                    {
                        if (i == 0)
                        {
                            bw2.write(String.valueOf(data1.vote1[j]));
                            //bw2.write("test");
                            bw2.newLine();
                        }
                        else if (i == 1)
                        {
                            bw2.write(String.valueOf(data1.vote2[j]));
                            bw2.newLine();
                        }
                        else if (i == 2)
                        {
                            bw2.write(String.valueOf(data1.vote3[j]));
                            bw2.newLine();
                        }
                    }
                    bw2.close();
                }

                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }
}
