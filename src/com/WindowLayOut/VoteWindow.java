package com.WindowLayOut;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.awt.*;

public class VoteWindow {
    Stage window;
    Stage window2;
    CanditateData data1;

    String st1="";
    String st2="";
    String st3="";
    VoteWindow(Stage window,CanditateData data1,Stage window2)
    {
        this.window = window;
        this.data1=data1;
        this.window2=window2;
        window.setTitle("Vote Cast Window");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10,10,10,10));

        int t=0,row=0,total=0,t1=0,t2=0,t3=0;




        final ToggleGroup group[]=new ToggleGroup[3];

        for (int i=0;i<3;i++){

            try {
                group[i]=new ToggleGroup();
                BufferedReader br= new BufferedReader(new FileReader("CanditateData\\Canditate"+i+".txt"));
                String s1 = br.readLine();
                total = Integer.parseInt(s1);
                if(total==0)
                {
                    total=-1;
                    break;
                }

                if(i==1)
                {
                    t1=total;
                }

                if(i==1) {
                    t2 = total;
                }
                if(i==2)
                {
                    t3=total;
                }

                if(i==1)
                {
                    String ChandidateName;
                    String CritariaName = br.readLine();
                    System.out.println(CritariaName);

                    row=0;

                    //Labeling
                    Label Name = new Label(CritariaName);
                    Name.setFont(new Font("Arial", 20));
                    Name.setUnderline(true);
                    //row+=i+t;
                    gridPane.add(Name, 25, row);


                    row++;

                    //System.out.println("notun cri");
                    for (int j = 0; j < total; j++) {
                        ChandidateName = br.readLine();
                        String CritariaLogo = br.readLine();

                        row++;

                        //Chandidate Labeling
                        Label Chandidate = new Label(ChandidateName);
                        Chandidate.setFont(new Font("Arial", 10));
                        gridPane.add(Chandidate, 23, row);

                        //logo Name labeling
                        Label logo = new Label(CritariaLogo);
                        logo.setFont(new Font("Arial", 10));
                        gridPane.add(logo, 25, row);

                        //Logo Labeling
                        //Label logoPic = new Label(CritariaLogo+".jpg");
                        //logoPic.setFont(new Font("Arial",10));
                        Image image = new Image("Logo\\" + CritariaLogo + ".jpg");
                        ImageView IV = new ImageView(image);
                        IV.setFitHeight(30);
                        IV.setFitWidth(30);
                        gridPane.add(IV, 26, row);

                        //RadioButton

                        RadioButton voteButton=new RadioButton("Vote "+(j+1));
                        voteButton.setToggleGroup(group[i]);
                        gridPane.add(voteButton, 28, row);

                        System.out.println(ChandidateName);
                        System.out.println(CritariaLogo);
                    }

                    row += 2;
                }


                else {
                    String ChandidateName;
                    String CritariaName = br.readLine();
                    System.out.println(CritariaName);

                    //Labeling
                    Label Name = new Label(CritariaName);
                    Name.setFont(new Font("Arial", 20));
                    Name.setUnderline(true);
                    //row+=i+t;
                    gridPane.add(Name, 2, row);


                    row++;

                    //System.out.println("notun cri");
                    for (int j = 0; j < total; j++) {
                        ChandidateName = br.readLine();
                        String CritariaLogo = br.readLine();

                        row++;

                        //Chandidate Labeling
                        Label Chandidate = new Label(ChandidateName);
                        Chandidate.setFont(new Font("Arial", 10));
                        gridPane.add(Chandidate, 0, row);

                        //logo Name labeling
                        Label logo = new Label(CritariaLogo);
                        logo.setFont(new Font("Arial", 10));
                        gridPane.add(logo, 2, row);

                        //Logo Labeling
                        //Label logoPic = new Label(CritariaLogo+".jpg");
                        //logoPic.setFont(new Font("Arial",10));
                        Image image = new Image("Logo\\" + CritariaLogo + ".jpg");
                        ImageView IV = new ImageView(image);
                        IV.setFitHeight(30);
                        IV.setFitWidth(30);
                        gridPane.add(IV, 3, row);

                        //RadioButton
                        //final ToggleGroup group = new ToggleGroup();
                        RadioButton voteButton=new RadioButton("Vote "+(j+1));
                        voteButton.setToggleGroup(group[i]);
                        gridPane.add(voteButton, 5, row);

                        System.out.println(ChandidateName);
                        System.out.println(CritariaLogo);
                    }

                    row += 2;
                }
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(t1!=0){
        try {
            group[0].selectedToggleProperty().addListener(new ChangeListener<Toggle>()
            {
                @Override
                public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1)
                {
                    RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
                    //System.out.println("Selected Radio Button - "+chk.getText());
                    st1=chk.getText();
                    //st1+="ant";
                }
            });

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        }


        if(t2!=0){

        try {
            group[1].selectedToggleProperty().addListener(new ChangeListener<Toggle>()
            {
                @Override
                public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1)
                {
                    RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle();
                    st2=chk.getText();
                    //System.out.println("Selected Radio Button - "+chk.getText());
                }
            });
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        }

        if(t3!=0){

            try {
                group[2].selectedToggleProperty().addListener(new ChangeListener<Toggle>()
                {
                    @Override
                    public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1)
                    {
                        RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle();
                        st3=chk.getText();
                        //System.out.println("Selected Radio Button - "+chk.getText());
                    }
                });
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }



        Button sumbitButton=new Button("Submit");
        gridPane.add(sumbitButton,27,9);
        sumbitButton.setOnAction(e -> {
            st1+=(st2+st3);
            boolean flag = new UpdateVote(st1,data1).methd();
            new ShowVote(window2,data1).Display();
            new SaveVote(data1);
            System.out.println(st1);
            window.close();
        });

        //gridPane.add(sumbitButton,27,9);


        Scene scene = new Scene(gridPane,1000,600);
        window.setScene(scene);
        //Scene scene = new Scene(gridPane,400,600);
        //window.setScene(scene);
        //window.show();
    }
}
