package com.WindowLayOut;

import com.AdminServer.TotalSelection;
import com.com.listShow.VoterListShow;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class FirstWindow {
    Stage window;
    CanditateData data1;
    int flag = 1;
    FirstWindow(Stage window,CanditateData data1)
    {
        Map<String ,Integer> mp = new HashMap<String, Integer>();
        Vector<Information> vector = new Vector <Information>(5,5);
        RetriveDataFromFile retriveDataFromFile = new RetriveDataFromFile(vector,mp);
        retriveDataFromFile.start();
        try {
            retriveDataFromFile.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            retriveDataFromFile.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(vector.size());
        this.window = window;
        window.setY(100);
        window.setX(300);



        Stage window2 = new Stage();
        //System.out.println("Ekhane");
        data1.totalVoter = vector.size();
        data1.check();
        new ShowVote(window2,data1).Display();
        window2.show();

        this.data1 = data1;


        Image playI=new Image("vote.png");
        ImageView iv1=new ImageView(playI);
        iv1.setFitHeight(100);
        iv1.setFitWidth(100);
        Button button = new Button("",iv1);

        Image play2=new Image("register.png");
        ImageView iv2=new ImageView(play2);
        iv2.setFitHeight(100);
        iv2.setFitWidth(100);
        Button button2 = new Button("",iv2);

        Image play3=new Image("list.png");
        ImageView iv3=new ImageView(play3);
        iv3.setFitHeight(100);
        iv3.setFitWidth(100);
        Button button3 = new Button("",iv3);

        Image play4=new Image("search.png");
        ImageView iv4=new ImageView(play4);
        iv4.setFitHeight(100);
        iv4.setFitWidth(100);
        Button button4 = new Button("",iv4);

        Image play5=new Image("canditate.png");
        ImageView iv5=new ImageView(play5);
        iv5.setFitHeight(60);
        iv5.setFitWidth(60);
        Button button5 = new Button("",iv5);

        button.setLayoutX(300);
        button.setLayoutY(200);

        button2.setLayoutX(550);
        button2.setLayoutY(200);

        button3.setLayoutX(300);
        button3.setLayoutY(400);

        button4.setLayoutX(550);
        button4.setLayoutY(400);

        button5.setLayoutX(100);
        button5.setLayoutY(400);

        Pane layout = new Pane();

        Image image = new Image("Background.png");
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(800);
        iv.setFitWidth(1500);
        Label label = new Label();
        label.setText("Digital Voting System");
        label.setLayoutX(400);
        label.setLayoutY(100);
        label.setFont(new Font("Arial",30));
        layout.getChildren().add(iv);
        layout.getChildren().addAll(button,button2,label,button3,button4,button5);
        Scene scene = new Scene(layout,1000,520);
        window.setScene(scene);

        button.setOnAction(event -> {
            System.out.println("Button 1 clicked.");
            //data1.totalVoter = vector.size();
            if (flag==0)
            {
                data1.Initial();
                new saveVotingCast(vector,1);
                flag=1;
            }
            new LoginWindow(vector,mp,data1,window2).Display(1);

        });

        button2.setOnAction(event -> {
            System.out.println("Button 2 clicked.");
            RegistrationWindow r1 = new RegistrationWindow(vector,mp);
            r1.display("Resigister","Voter Registration");


        });

        button3.setOnAction(event -> {
            System.out.println("Button 3 Clicked.");
            new VoterListShow(vector);
        });

        button4.setOnAction(event -> {
            System.out.println("Button 4 Clicked.");
            new LoginWindow(vector,mp).Display(2);
        });

        button5.setOnAction(event -> {
            System.out.println("Button 5 clicked.");
            //new CanditateSelectWindow();
            PermissionWindow obj1 = new PermissionWindow();
            boolean choice = obj1.Login();



            if (choice) {
                System.out.println("yes");
                new MakeEerthingZero();
                TotalSelection t1 = new TotalSelection();
                flag =0;
            }
            else
                System.out.println("no");
        });
    }
}
