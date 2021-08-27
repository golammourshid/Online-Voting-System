package com.WindowLayOut;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;


public class LoginWindow {

    Vector<Information> vector;
    Map<String ,Integer> mp;
    CanditateData data1;
    Stage window2;
    LoginWindow(Vector <Information> vector,Map<String ,Integer> mp)
    {
        this.mp=mp;
        this.vector=vector;
    }

    public LoginWindow(Vector<Information> vector, Map<String, Integer> mp, CanditateData data1,Stage window2) {
        this.mp=mp;
        this.vector=vector;
        this.data1=data1;
        this.window2=window2;
    }

    public void Display(int type)
    {
        int delay = 1000*10*60;
        Stage window = new Stage();
        window.setTitle("Login Window");
        BorderPane bp = new BorderPane();
        Image image;
        if (type == 1) {
            image = new Image("Picture\\Login1.jpg");
        }
        else {
            image = new Image("Picture\\Login2.jpg");
        }
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(800);
        iv.setFitWidth(1500);

        bp.getChildren().add(iv);


        bp.setPadding(new Insets(10,50,50,50));

        //Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));

        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //Implementing Nodes for GridPane
        Label lblUserName = new Label("Registration ID");
        final TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Login");
        final Label lblMessage = new Label();
        //final Label wrongMessage = new Label();

        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 1, 2);
        gridPane.add(lblMessage, 1, 3);


        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        //Adding text and DropShadow effect to it
        Text text = new Text("Please Login First");
        text.setFont(Font.font ("Verdana", 30));
        text.setEffect(dropShadow);

        //Adding text to HBox
        hb.getChildren().add(text);

        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        text.setId("text");


        btnLogin.setOnAction(event -> {
            String UserName = txtUserName.getText();

            if (mp.get(UserName) == null)
            {
                lblMessage.setText("ID didn't matched!");
            }
            else {
                int index = mp.get(UserName);
                String UserPass = pf.getText();
                String  pass = vector.get(index).getPassWord();
                if(pass.equals(UserPass))
                {
                    if (type==2)
                    {
                        new InformationShowWindow(vector.get(index)).display(2);
                        window.close();
                    }
                    else {
                        if (!vector.get(index).vote) {
                            //System.out.println("notun window jabe");
                            data1.totalVote +=1;
                            new VoteWindow(window,data1,window2);
                            lblMessage.setText(" ");
                            if (type == 1) {
                                Timer timer = new Timer();
                                vector.get(index).vote = true;
                                new saveVotingCast(vector);
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        vector.get(index).vote = false;
                                    }
                                }, delay);
                            }

                        } else {
                            lblMessage.setText("Voter has Already Voted!");
                        }
                    }
                }
                 else{
                    lblMessage.setText("Passwor didn't matched!");
                }
            }

        });

        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);

        //Adding BorderPane to the scene and loading CSS
        Scene scene = new Scene(bp);
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();


    }
}
