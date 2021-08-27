package com.com.listShow;

import com.WindowLayOut.Information;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.util.Vector;

public class VoterListShow{


    Vector<Information> vector; //= new Vector<>();
    Information obj,obj1;

    //Window window;
    //Stage stage;
    Stage stage;
    private TableView<Person> table = new TableView<>();

    public VoterListShow(Vector<Information> vector) {
        this.vector=vector;
        Display();
    }

    public void Display() {

        Stage stage = new Stage();
        Scene scene = new Scene(new Group());

        final Label label = new Label("Voter Information");
        label.setFont(new Font("Arial", 20));
        label.setAlignment(Pos.CENTER);


            //obj1 = vector.get(1);

            //obj.setSerial("1");
            //obj1.setSerial("1");

            ObservableList<Person> data = FXCollections.observableArrayList();
        for(int i=1;i<=vector.size();i++) {
            obj = vector.get(i - 1);
            //String ss = String.valueOf(i);
            data.addAll(new Person(i, obj.getRegID(), obj.getName(), obj.getPostcode(), obj.getEmail(),obj.getDivision()));
        }//data.addAll(new Person("samiha","jhgashgh","jhafghgh"));




            table.setEditable(true);

            TableColumn serialNumberCol = new TableColumn("Serial Number");
            serialNumberCol.setMinWidth(100);
            serialNumberCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("serialNumber"));


            TableColumn registrationNumberCol = new TableColumn("Registration Number");
            registrationNumberCol.setMinWidth(200);
            registrationNumberCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("registrationNumber"));

            TableColumn nameCol = new TableColumn("Name");
            nameCol.setMinWidth(100);
            nameCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("name"));

        TableColumn DivisonCol = new TableColumn("Divison");
        DivisonCol.setMinWidth(100);
        DivisonCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("Divison"));


            TableColumn postCodeCol = new TableColumn("Post Code");
            postCodeCol.setMinWidth(100);
            postCodeCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("postCode"));

            TableColumn emailCol = new TableColumn("Email");
            emailCol.setMinWidth(200);
            emailCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("email"));

            table.setItems(data);
           // int a = 1;


            //data.addAll(new Person(ss, obj.getRegID(), obj.getName(), obj.getPostcode(), obj.getEmail()));
            //data.addAll(new Person("2", obj1.getRegID(), obj1.getName(), obj1.getPostcode(), obj1.getEmail()));

            table.getColumns().addAll(serialNumberCol, registrationNumberCol, nameCol,DivisonCol, postCodeCol, emailCol);


        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        scene.getStylesheets().add("B1.css");
        stage.setScene(scene);
        stage.show();

    }
}
