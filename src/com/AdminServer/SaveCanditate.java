package com.AdminServer;

import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SaveCanditate {
    TextField[] canditate;
    String[] logolist;
    int total;
    String name;
    SaveCanditate(TextField[] canditate,String[] logolist,int total,String name,int j)
    {
        this.canditate=canditate;
        this.logolist=logolist;
        this.total = total;
        this.name = name;

        try {
            System.out.println("Ekhane ase?");
            File file = new File("CanditateData\\Canditate"+j+".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            File file2 = new File("CanditateData\\CanditateVote"+j+".txt");
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
            bw2.write(Integer.toString(total));
            bw2.newLine();

            bw.write(Integer.toString(total));
            bw.newLine();

            bw.write(name);
            bw.newLine();
            for (int i=0;i<total;i++)
            {
                System.out.println("hpp");
                String str="";
                str = canditate[i].getText();
                bw.write(str);
                bw.newLine();
                str=logolist[i];
                bw.write(str);
                bw.newLine();
                bw2.write("0");
                bw2.newLine();
            }
            bw.close();
            bw2.close();
        }
        catch (Exception e)
        {

        }
    }
}
