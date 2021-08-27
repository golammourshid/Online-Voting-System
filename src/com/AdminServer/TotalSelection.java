package com.AdminServer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TotalSelection {
   public TotalSelection()
   {
       Stage window = new Stage();
       window.setTitle("Canditate Selection");
       ObservableList<String> options =
               FXCollections.observableArrayList(
                       "1","2","3"
               );
       final ComboBox comboBox = new ComboBox(options);
       Label Label = new Label("Number of Voting Critaria : ");
       Button Okay = new Button(" Okay ");
       GridPane gridPane = new GridPane();
       Label temp = new Label("         ");
       gridPane.setVgap(10);
       gridPane.setHgap(30);
       gridPane.add(temp,0,0);
       gridPane.add(Label,0,2,1,1);
       gridPane.add(comboBox,1,2);
       gridPane.add(Okay,2,2);
       Scene scene = new Scene(gridPane,400,200);
       window.setScene(scene);
       window.show();

       Okay.setOnAction(event -> {
           String s = (String) comboBox.getValue();
           System.out.println(s);
           int total;
           if (s.equals("1")) total = 1;
           else if (s.equals("2")) total = 2;
           else total = 3;
           //int total = Integer.parseInt(s);
           window.close();
           int i = 0;
           new CanditateSelectWindow(total,i);
       });


   }

   public void end(){
       return;
   }
}
