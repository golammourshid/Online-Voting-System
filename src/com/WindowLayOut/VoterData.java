package com.WindowLayOut;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class VoterData {
    VoterData(String Data) {
        try {
            FileWriter fileWriter=new FileWriter("Voter Data.txt",true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(Data);
            bufferedWriter.newLine();
            //bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) { }
    }
}
