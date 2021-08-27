package com.AdminServer;

import com.WindowLayOut.Information;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NotunWindow extends Application {
    public Information obj1;

    public NotunWindow(Information obj1) {
        this.obj1 = obj1;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(new Label("Server ready"),3,3);
        Scene scene = new Scene(gridPane,400,400);
        Button Ok = new Button("OK");
        gridPane.add(Ok,3,4);
        window.setScene(scene);
        window.setAlwaysOnTop(true);
        window.show();
        Ok.setOnAction(event -> System.out.println("notn"));
        //int i = new AdminPermission(obj1).permission();
        int i = 0;
        String s11 = String.valueOf(i);
        gridPane.add(new Label(s11),0,0);
        System.out.println(obj1.getName());
    }
}
