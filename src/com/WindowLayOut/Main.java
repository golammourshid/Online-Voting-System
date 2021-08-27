package com.WindowLayOut;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Vector;

public class Main extends Application {
    static Vector<Information> vector1;
    static CanditateData data1 = new CanditateData();
    public static void main(String[] args) {
        launch(args);
        //System.out.println("End");
        //new SaveVote(data1);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("Digital Voting System");
        window.show();
        FirstWindow firstWindow = new FirstWindow(window,data1);
    }
}
