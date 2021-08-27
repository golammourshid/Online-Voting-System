package com.WindowLayOut;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminPermissionShowWindow {
    String message;
    AdminPermissionShowWindow(String message)
    {
        this.message = message;
    }
    public void Display(String regid,int type)
    {
        Stage windwow2 = new Stage();
        windwow2.setTitle(message);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        Label regShow = new Label("          "+message);
        regShow.setFont(new Font("Arial", 17));
        grid.add(regShow, 1, 2, 2, 1);

        if (type == 1) {
            regShow.setTextFill(Color.GREEN);
            Label regSh = new Label("Your Registration Id is : ");
            regSh.setFont(new Font("Arial", 17));
            grid.add(regSh,1,4,2,1);
            TextField txt = new TextField(regid);
            txt.setEditable(false);
            grid.add(txt,3,4);
        }
        if (type == 2) {
            regShow.setTextFill(Color.RED);
        }
        Scene scene2 = new Scene(grid,500,200);
        Button okay = new Button("Okay");
        Label temp = new Label("              ");
        grid.add(temp,2,6);
        grid.add(okay,4,6);
        windwow2.setScene(scene2);
        windwow2.show();
        okay.setOnAction(event -> windwow2.close());
    }
}
