package com.WindowLayOut;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShowVote {
    Stage window;
    CanditateData data;

    public ShowVote(Stage window2,CanditateData data) {
        this.window = window2;
        this.data = data;
    }

    public void Display()
    {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        int row = 0;

        gridPane.add(new Label("Total Vote Cast = "),0,0);
        gridPane.add(new Label(String.valueOf(data.totalVote)),1,0);
        double percentage = (double) data.totalVote / (double)data.totalVoter;
        ProgressBar b1 = new ProgressBar(percentage);
        ProgressIndicator pi = new ProgressIndicator(percentage);
        gridPane.add(b1,2,0);
        gridPane.add(pi,3,0);


        for (int i =0;i<3;i++)
        {
            if (data.total[i]!=0) {
                row = 1;
                Label critariaLabel = new Label(data.critaria[i]);
                critariaLabel.setUnderline(true);
                critariaLabel.setFont(new Font("Bold",12));
                gridPane.add(critariaLabel,i+(1*i),row++);

                for (int j=0;j<data.total[i];j++)
                {
                    if (i==0)
                    {
                        gridPane.add(new Label(data.name1[j]),i,row);
                        gridPane.add(new Label(String.valueOf(data.vote1[j])),i+1,row++);
                    }
                    if (i==1)
                    {
                        gridPane.add(new Label(data.name2[j]),i+1,row);
                        gridPane.add(new Label(String.valueOf(data.vote2[j])),i+2,row++);
                    }
                    if (i==2)
                    {
                        gridPane.add(new Label(data.name3[j]),i+2,row);
                        gridPane.add(new Label(String.valueOf(data.vote3[j])),i+3,row++);
                    }
                }
            }
        }
        Scene scene = new Scene(gridPane,600,200);
        window.setScene(scene);
        window.setX(0);
        window.setY(0);
        return;
    }
}
