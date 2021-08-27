package com.AdminServer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class CanditateSelectWindow  {
    int total=5;
    String name;
    int ii;
    int totalC;
    Stage window = new Stage();
    GridPane grid = new GridPane();
    TextField[] canditate = new TextField[5];
    Button[] selection = new Button[5];
    String[] logolist = new String[5];
    Map<String,Integer> map=new HashMap<String,Integer>();
    ChoiceBox<String>[] LogoChoiceBox = new ChoiceBox[5];
    int[] flag = new int[5];
    Label[] messege = new Label[5];
    Button ok = new Button("OK");
    CanditateSelectWindow(int totalC,int i)
    {
        this.totalC = totalC;
        this.ii = i;
        window.setTitle("Canditate Information window");
        grid.setVgap(10);
        grid.setHgap(10);
        Button submitButton = new Button("Submit");
        Scene scene = new Scene(grid,600,500);
        window.setScene(scene);
        window.show();


        //first row
        Label Critaria = new Label("Critaria Name");
        TextField CritariaField = new TextField();
        CritariaField.setPromptText("Critaria Name");
        grid.add(Critaria,0,0);
        grid.add(CritariaField,1,0);

        grid.add(ok,4,0);

        Label totalCandi = new Label("Total Canditate ");
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "2","3","4","5"
                );

        final ComboBox comboBox = new ComboBox(options);
        grid.add(totalCandi,2,0);
        grid.add(comboBox,3,0);
        ok.setOnAction(event -> {
            name = CritariaField.getText();
            String tota = (String) comboBox.getValue();
            int tt = Integer.parseInt(tota);
            total = tt;
            new makeWindow(window,grid,canditate,selection,map,logolist,LogoChoiceBox,total);
            int row1 = total*2+1;
            grid.add(submitButton,4,row1,2,1);
            AfterYes();
        });

        submitButton.setOnAction(event -> {
            if (flag[0]==1)
            {
                System.out.println("sob thik");
                new SaveCanditate(canditate,logolist,total,name,ii);
                window.close();
                ii++;
                if (ii != totalC)
                {
                    new CanditateSelectWindow(totalC,ii);
                }
            }

        });
    }


    public void AfterYes()
    {
        ok.setDisable(true);
        for (int i=0;i<5;i++) {
            Label temp = new Label(" ");
            messege[i] = temp;
        }
        if (total == 5) {
            selection[0].setOnAction(event -> {
                flag[0] = action(messege[0], map, grid, LogoChoiceBox[0], logolist, 0, canditate);
            });

            selection[1].setOnAction(event -> {
                flag[1] = action(messege[1], map, grid, LogoChoiceBox[1], logolist, 1, canditate);
            });

            selection[2].setOnAction(event -> {
                flag[2] = action(messege[2], map, grid, LogoChoiceBox[2], logolist, 2, canditate);
            });

            selection[3].setOnAction(event -> {
                flag[3] = action(messege[3], map, grid, LogoChoiceBox[3], logolist, 3, canditate);
            });

            selection[4].setOnAction(event -> {
                flag[4] = action(messege[4], map, grid, LogoChoiceBox[4], logolist, 4, canditate);
            });

        }

        if (total == 4)
        {
            selection[0].setOnAction(event -> {
                flag[0] = action(messege[0], map, grid, LogoChoiceBox[0], logolist, 0, canditate);
            });

            selection[1].setOnAction(event -> {
                flag[1] = action(messege[1], map, grid, LogoChoiceBox[1], logolist, 1, canditate);
            });

            selection[2].setOnAction(event -> {
                flag[2] = action(messege[2], map, grid, LogoChoiceBox[2], logolist, 2, canditate);
            });

            selection[3].setOnAction(event -> {
                flag[3] = action(messege[3], map, grid, LogoChoiceBox[3], logolist, 3, canditate);
            });
        }


        if (total==3)
        {
            selection[0].setOnAction(event -> {
                flag[0] = action(messege[0], map, grid, LogoChoiceBox[0], logolist, 0, canditate);
            });

            selection[1].setOnAction(event -> {
                flag[1] = action(messege[1], map, grid, LogoChoiceBox[1], logolist, 1, canditate);
            });

            selection[2].setOnAction(event -> {
                flag[2] = action(messege[2], map, grid, LogoChoiceBox[2], logolist, 2, canditate);
            });
        }

        else if (total == 2)
        {
            selection[0].setOnAction(event -> {
                flag[0] = action(messege[0], map, grid, LogoChoiceBox[0], logolist, 0, canditate);
            });

            selection[1].setOnAction(event -> {
                flag[1] = action(messege[1], map, grid, LogoChoiceBox[1], logolist, 1, canditate);
            });
        }


    }


    public int action(Label messege,Map<String,Integer> map,GridPane grid,ChoiceBox<String> LogoChoiceBox,String[] logolist,int i,TextField[] canditate)
    {
        int row = i*2+1;
        int flag = 0;
        if (canditate[i].getText().equals(""))
        {
            messege.setText("Enter Canditate name");
            messege.setTextFill(Color.web("#ff0000"));
        }
        else {
            if (LogoChoiceBox.getValue() == null) {
                System.out.println("selet koro");
                messege.setText("Please Select a logo");
                messege.setTextFill(Color.web("#ff0000"));

            } else {
                String choice = LogoChoiceBox.getValue();
                if (map.get(choice) == 0) {
                    map.put(choice, 1);
                    map.put(logolist[i], 0);
                    logolist[i] = choice;
                    messege.setText("Logo added Successfully!");
                    messege.setTextFill(Color.web("#008000"));
                    ImageView imageHouse = new ImageView(new Image("Logo\\" + choice + ".jpg"));
                    imageHouse.setFitWidth(40);
                    imageHouse.setFitHeight(40);
                    grid.add(imageHouse, 4, row);
                    flag = 1;
                }
                else {
                    messege.setText("Logo Already taken!");
                    messege.setTextFill(Color.web("#ff0000"));
                }

            }
        }

        //System.out.println("but 1");
        grid.getChildren().remove(messege);
        grid.add(messege,1,row+1);
        return flag;
    }
}

