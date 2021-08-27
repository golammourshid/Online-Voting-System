package com.WindowLayOut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Temp {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("Voter Data.txt")));
        Vector <Information> vector = new Vector <Information>(5,5);
        String line;
        while ((line = br.readLine())!=null)
        {
            Information obj = new Information();
            System.out.println(line);
            StringTokenizer st = new StringTokenizer(line,"#");
            for (int i=0;i<11;i++)
            {
                if(i==0) obj.setName(st.nextToken());
                else if(i==1) obj.setFatherName(st.nextToken());
                else if(i==2) obj.setMotherNamae(st.nextToken());
                else if(i==3) obj.setGender(st.nextToken());
                else if(i==4) obj.setBirthDay(st.nextToken());
                else if(i==5) obj.setBlood(st.nextToken());
                else if(i==6) obj.setDivision(st.nextToken());
                else if(i==7) obj.setDistrict(st.nextToken());
                else if(i==8) obj.setPostcode(st.nextToken());
                else if(i==9) obj.setContactNo(st.nextToken());
                else if(i==10) obj.setEmail(st.nextToken());
            }
            //System.out.println(obj.gender);
            vector.add(obj);
        }
        System.out.println(vector.size());
    }
}
