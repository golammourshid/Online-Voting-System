package com.AdminServer;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class notun {
    notun()
    {
        Stage window = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(new Label("notun ready"),3,3);
        Scene scene = new Scene(gridPane,400,400);
        window.setScene(scene);
        window.showAndWait();
    }
}
