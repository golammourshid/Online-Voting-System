package com.WindowLayOut;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class PermissionWindow {
    boolean flag = false;
    public boolean Login()
    {
        Stage window =  new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label name = new Label("Name ");
        TextField nameText = new TextField();
        gridPane.add(name,1,1);
        gridPane.add(nameText,2,1);
        Label pass = new Label("Password ");
        PasswordField passText = new PasswordField();
        gridPane.add(pass,1,2);
        gridPane.add(passText,2,2);
        Button confirm = new Button("Confirm");
        gridPane.add(confirm,1,3);
        Scene scene = new Scene(gridPane,400,200);
        window.setScene(scene);


        confirm.setOnAction(event -> {



            String ss = nameText.getText();
            String s2 = passText.getText();
            if (ss.equals("admin") && s2.equals("admin")){
                window.close();
                flag = true;
            }
            else {
                Label warning = new Label("Name or Password didn't match!");
                warning.setTextFill(Color.RED);
                gridPane.add(warning,1,4,3,1);
            }
            System.out.println(ss+"   "+s2);
        });

        window.showAndWait();

        return flag;

    }
}
