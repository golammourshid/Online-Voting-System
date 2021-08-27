package com.WindowLayOut;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CanditateData {
    int [] total = new int[3];
    String [] name1;
    String [] name2;
    String [] name3;
    int[] vote1;
    int[] vote2;
    int[] vote3;
    String[] critaria = new String[3];
    int totalVote;
    int totalVoter;
    CanditateData()
    {
        try {
            BufferedReader br3 = new BufferedReader(new FileReader("CanditateData\\totalVote.txt"));
            String temp = br3.readLine();
            totalVote = Integer.parseInt(temp);
            br3.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i =0;i<3;i++) {
            try {
                BufferedReader br = new BufferedReader(new FileReader("CanditateData\\Canditate" + i + ".txt"));
                BufferedReader br2 = new BufferedReader(new FileReader("CanditateData\\CanditateVote" + i + ".txt"));

                String s1 = br.readLine();
                total[i] = Integer.parseInt(s1);
                s1 = br2.readLine();
                //System.out.println("From show vote  " + total);
                if (total[i] != 0) {
                    critaria[i] = br.readLine();
                    if (i==0)
                    {
                        name1 = new String[total[i]];
                        vote1 = new int[total[i]];
                    }

                    if (i==1)
                    {
                        name2 = new String[total[i]];
                        vote2 = new int[total[i]];
                    }

                    if (i==2)
                    {
                        name3 = new String[total[i]];
                        vote3 = new int[total[i]];
                    }

                    for (int j = 0; j < total[i]; j++) {
                        if (i==0)
                        {
                            name1[j] = br.readLine();
                            String logo = br.readLine();
                            vote1[j] = Integer.parseInt(br2.readLine());
                        }

                        else if (i==1)
                        {
                            name2[j] = br.readLine();
                            String logo = br.readLine();
                            vote2[j] = Integer.parseInt(br2.readLine());
                        }

                        else if (i==2 )
                        {
                            name3[j] = br.readLine();
                            String logo = br.readLine();
                            vote3[j] = Integer.parseInt(br2.readLine());
                        }
                    }

                    br.close();
                    br2.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Initial()
    {
        try {
            BufferedReader br3 = new BufferedReader(new FileReader("CanditateData\\totalVote.txt"));
            String temp = br3.readLine();
            totalVote = Integer.parseInt(temp);
            br3.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i =0;i<3;i++) {
            try {
                BufferedReader br = new BufferedReader(new FileReader("CanditateData\\Canditate" + i + ".txt"));
                BufferedReader br2 = new BufferedReader(new FileReader("CanditateData\\CanditateVote" + i + ".txt"));

                String s1 = br.readLine();
                total[i] = Integer.parseInt(s1);
                s1 = br2.readLine();
                //System.out.println("From show vote  " + total);
                if (total[i] != 0) {
                    critaria[i] = br.readLine();
                    if (i==0)
                    {
                        name1 = new String[total[i]];
                        vote1 = new int[total[i]];
                    }

                    if (i==1)
                    {
                        name2 = new String[total[i]];
                        vote2 = new int[total[i]];
                    }

                    if (i==2)
                    {
                        name3 = new String[total[i]];
                        vote3 = new int[total[i]];
                    }

                    for (int j = 0; j < total[i]; j++) {
                        if (i==0)
                        {
                            name1[j] = br.readLine();
                            String logo = br.readLine();
                            vote1[j] = Integer.parseInt(br2.readLine());
                        }

                        else if (i==1)
                        {
                            name2[j] = br.readLine();
                            String logo = br.readLine();
                            vote2[j] = Integer.parseInt(br2.readLine());
                        }

                        else if (i==2 )
                        {
                            name3[j] = br.readLine();
                            String logo = br.readLine();
                            vote3[j] = Integer.parseInt(br2.readLine());
                        }
                    }

                    br.close();
                    br2.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void check()
    {
        for (int i = 0;i<3;i++)
        {
            System.out.println("total = "+total[i]);
            for (int j=0;j<total[i];j++)
            {
                if (i==0)
                {
                    System.out.println("name = "+name1[j]+" vote = "+vote1[j]);
                }
                if (i==1)
                {
                    System.out.println("name = "+name2[j]+" vote = "+vote2[j]);
                }
                if (i==2)
                {
                    System.out.println("name = "+name3[j]+" vote = "+vote3[j]);
                }
            }
            System.out.println("\n");
        }
    }
}
