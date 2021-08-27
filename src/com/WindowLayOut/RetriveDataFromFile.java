package com.WindowLayOut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

public class RetriveDataFromFile extends Thread {
    Vector<Information> vector;
    Map<String ,Integer> mp;
    RetriveDataFromFile(Vector <Information> vector,Map<String ,Integer> mp)
    {
        this.vector=vector;
        this.mp = mp;
    }
    public void run()
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("Voter Data.txt")));
            BufferedReader br2 = new BufferedReader(new FileReader(new File("CanditateData\\IsVote.txt")));
            String line;
            while ((line = br.readLine())!=null)
            {

                Information obj = new Information();
                String temp = br2.readLine();
                if (temp.equals("1"))
                {
                    obj.vote = true;
                }

                //System.out.println(line);
                StringTokenizer st = new StringTokenizer(line,"#");
                for (int i=0;i<13;i++)
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
                    else if (i==11) obj.setPassWord(st.nextToken());
                    else if (i==12)obj.setRegID(st.nextToken());
                }
                //System.out.println(obj.regID);
                mp.put(obj.regID,vector.size());
                vector.add(obj);
                //mp.put()
            }

        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
