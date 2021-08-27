package com.AdminServer;

import com.WindowLayOut.AdminPermission;
import com.WindowLayOut.Information;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MessageWindow {
    int flag=0;
    Information info;

    public int display()
    {

        Stage window = new Stage();
        window.setTitle("New Massage");
        Label label = new Label("New Registration Request.");
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), label);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(label,6,3);
        Button open = new Button("Close");
        gridPane.add(open,8,4);
        Scene scene = new Scene(gridPane,400,200);
        new BeeperControl().beepForAnHour();
        window.setScene(scene);
        open.setOnAction(event -> {
            flag = 2;
            System.out.println("hoise");
            window.close();
        });
       // window.setY(0);
       // window.setX(0);
        window.showAndWait();


        return flag;
    }
}
