package com.AdminServer;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class makeWindow {
    Stage window;
    GridPane grid;
    int total;
    TextField[] canditate;
    Button[] selection;
    Map<String,Integer> map;
    String[] logolist;
    ChoiceBox<String>[] LogoChoiceBox;
    makeWindow(Stage window,GridPane grid,TextField[] canditate, Button[] selection,Map<String,Integer> map,String[] logolist,ChoiceBox<String>[] LogoChoiceBox,int total)
    {
        this.window = window;
        this.grid = grid;
        this.canditate = canditate;
        this.selection = selection;
        this.logolist=logolist;
        this.map=map;
        this.LogoChoiceBox = LogoChoiceBox;
        this.total = total;
        window.setTitle("Voter selection");
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        mapSet();
        loop();
    }
    void mapSet()
    {
        map.put("laptop",0);
        map.put("mouse",0);
        map.put("keyboard",0);
        map.put("router",0);
        map.put("sattalite",0);
        map.put("headphone",0);
        map.put("temp",0);
    }


    void loop()
    {
        for (int i=0;i<total;i++)
        {
            int row = (i*2)+1;
            Label name1 = new Label("Canditate Name");
            TextField canditate2 = new TextField();
            canditate[i] = canditate2;

            ChoiceBox<String> LogoChoiceBox1=new ChoiceBox<>();
            LogoChoiceBox1.getItems().addAll("laptop","mouse","keyboard","router","headphone","sattalite");
            LogoChoiceBox[i] = LogoChoiceBox1;


            Button button = new Button("OK");
            selection[i]=button;
            grid.add(selection[i],5,row);
            grid.add(LogoChoiceBox[i],2,row);
            grid.add(name1,0,row);
            grid.add(canditate[i],1,row);

            logolist[i] = "temp";
        }
    }

    void remove()
    {
        for (int i=0;i<5;i++){
            grid.getChildren().remove(selection[i]);
        }
    }

}
