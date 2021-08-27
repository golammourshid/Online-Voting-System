package com.WindowLayOut;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InformationShowWindow {
    Information stdInf;
    int flag = 0;
    InformationShowWindow(Information obj1)
    {
        this.stdInf=obj1;
    }
    public int display(int type)
    {
        Stage window = new Stage();
        window.setTitle("Login Window");

        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(20);
        gridPane.setVgap(15);

        /*/For parameter Messsage
        Label label = new Label();
        //label.setText(message);
        label.setLayoutX(300);
        label.setLayoutY(50);
        label.setFont(new Font("Arial",25));
        GridPane.setConstraints(label,6,0);*/

        //User Name
        Label userNameLabel=new Label("Name:");
        userNameLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(userNameLabel,0,2);

        //For mouse handler
        userNameLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                userNameLabel.setScaleX(1.2);
                userNameLabel.setScaleY(1.2);
            }
        });

        userNameLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                userNameLabel.setScaleX(1);
                userNameLabel.setScaleY(1);
            }
        });


        //UserName Text Field
        TextField userNameTextField=new TextField();

        userNameTextField.setText(stdInf.getName());
        userNameTextField.setEditable(false);
        GridPane.setConstraints(userNameTextField,1,2);


        //Father Name
        Label fatherNameLabel=new Label("Father's Name:");
        fatherNameLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(fatherNameLabel,0,4);

        //FatherName Text Field
        TextField fatherNameTextField=new TextField();
        fatherNameTextField.setText(stdInf.getFatherName());
        fatherNameTextField.setEditable(false);
        GridPane.setConstraints(fatherNameTextField,1,4);

        //Mother Name Label
        Label motherNameLabel=new Label("Mother's Name:");
        motherNameLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(motherNameLabel,0,6);

        //MotherName Text Field
        TextField motherNameTextField=new TextField();
        motherNameTextField.setText(stdInf.getMotherNamae());
        motherNameTextField.setEditable(false);
        GridPane.setConstraints(motherNameTextField,1,6);
        gridPane.getChildren().addAll(motherNameLabel,motherNameTextField);

        //Gender Label
        Label genderLabel=new Label("Gender:");
        genderLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(genderLabel,0,8);

        //Gender Text Field
        //stdInf.setGender("male");
        TextField maleGendertextField=new TextField(stdInf.getGender());
        maleGendertextField.setEditable(false);
        GridPane.setConstraints(maleGendertextField,1,8);
        gridPane.getChildren().addAll(genderLabel,maleGendertextField);

        //Birthday label
        Label birthdayLabel=new Label("Birthday:");
        birthdayLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(birthdayLabel,0,10);

        //Birthday Text Field
        TextField birthdayTextField=new TextField(stdInf.getBirthDay());
        //birthdayTextField.setPromptText("dd/mm/yyyy");
        birthdayTextField.setEditable(false);
        GridPane.setConstraints(birthdayTextField,1,10);
        gridPane.getChildren().addAll(birthdayTextField,birthdayLabel);

        //Blood Group label
        Label bloodGroupLabel=new Label("Blood Group:");
        bloodGroupLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(bloodGroupLabel,0,12);

        //Blood Group Text Field
        TextField bloodGroupTextField=new TextField(stdInf.getBlood());
        bloodGroupTextField.setEditable(false);

        GridPane.setConstraints(bloodGroupTextField,1,12);
        gridPane.getChildren().addAll(bloodGroupLabel,bloodGroupTextField);

        //Division
        Label divisionLabel=new Label("Division:");
        divisionLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(divisionLabel,0,14);

        //Division TextField
        TextField divisionTextField=new TextField(stdInf.getDivision());
        divisionTextField.setDisable(false);
        GridPane.setConstraints(divisionTextField,1,14);
        gridPane.getChildren().addAll(divisionTextField,divisionLabel);

        //District label
        Label districtLabel=new Label("District:");
        districtLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(districtLabel,0,16);

        //District Text Field
        TextField districtTextField=new TextField(stdInf.getDistrict());
        districtTextField.setEditable(false);
        GridPane.setConstraints(districtTextField,1,16);
        gridPane.getChildren().addAll(districtTextField,districtLabel);

        //Post Code Label
        Label PostcodeLabel=new Label("Postcode:");
        PostcodeLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(PostcodeLabel,6,2);

        //Post Code Text Field
        TextField postcodeTextField=new TextField(stdInf.getPostcode());
        postcodeTextField.setEditable(false);
        GridPane.setConstraints(postcodeTextField,7,2);
        gridPane.getChildren().addAll(PostcodeLabel,postcodeTextField);

        //Contact Number label
        Label ContactLabel=new Label("Contact No.:");
        ContactLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(ContactLabel,6,4);

        //Contact Number Text Field
        TextField contactNumberTextField=new TextField(stdInf.getContactNo());
        contactNumberTextField.setEditable(false);
        GridPane.setConstraints(contactNumberTextField,7,4);
        gridPane.getChildren().addAll(contactNumberTextField,ContactLabel);

        //Email label
        Label emailLabel=new Label("Email:");
        emailLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(emailLabel,6,6);

        //Email Text Field
        TextField emailTextField=new TextField(stdInf.getEmail());
        emailTextField.setEditable(false);
        GridPane.setConstraints(emailTextField,7,6);
        gridPane.getChildren().addAll(emailLabel,emailTextField);

        //Add All
        gridPane.getChildren().addAll(fatherNameTextField,fatherNameLabel,userNameLabel,userNameTextField);

        if(type == 1)
        {
            Button yes = new Button("Confirm");
            Button no = new Button("Cancel");
            gridPane.add(yes,6,8);
            gridPane.add(no,7,8);


            yes.setOnAction(event -> {
                window.close();
                flag = 2;
            });
            no.setOnAction(event -> {
                window.close();
                flag = 3;
            });
        }

        if (type == 2)
        {
            Button Close = new Button("Close");
            gridPane.add(Close,6,8);

            Close.setOnAction(event -> window.close());
        }

        Scene scene = new Scene(gridPane,1000,600);
        scene.getStylesheets().add("B1.css");
        window.setScene(scene);
        window.showAndWait();
        //stdInf.getBirthDay();

        return flag;
    }
}
