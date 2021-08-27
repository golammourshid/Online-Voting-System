package com.WindowLayOut;

import com.AdminServer.MessageWindow;
import com.Client.AdminClient;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;
import java.util.Vector;


public class RegistrationWindow {

    String stringUserName=new String();
    String stringFatherName=new String();
    String stringMotherName=new String();
    String stringBirthday=new String();
    String stringBloodGroup=new String();
    String stringDivisionChoiceBoxValue=new String();
    String stringDistrictName=new String();
    String stringPostCode=new String();
    String stringContactNumber=new String();
    String regID = new String();
    String stringemail=new String();
    String totalString=new String();

    Vector<Information> vector;
    Map<String ,Integer> mp;
    RegistrationWindow(Vector <Information> vector,Map<String ,Integer> mp)
    {
        this.vector=vector;
        this.mp = mp;
    }

    public void display(String title, String message) {

        Stage window = new Stage();
        Stage window2 = new Stage();
        //window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        //String
        // stringFatherName

        //Gridpane
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(20);
        gridPane.setVgap(15);

        //For parameter Messsage
        Label label = new Label();
        label.setText(message);
        label.setLayoutX(300);
        label.setLayoutY(50);
        label.setFont(new Font("Arial",25));
        GridPane.setConstraints(label,6,0);

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

        userNameTextField.setPromptText("Username");
        GridPane.setConstraints(userNameTextField,1,2);


        //Father Name
        Label fatherNameLabel=new Label("Father's Name:");
        fatherNameLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(fatherNameLabel,0,4);

        //FatherName Text Field
        TextField fatherNameTextField=new TextField();
        fatherNameTextField.setPromptText("Father's name");
        GridPane.setConstraints(fatherNameTextField,1,4);

        //Mother Name
        Label motherNameLabel=new Label("Mother's Name:");
        motherNameLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(motherNameLabel,0,6);

        //MotherName Text Field
        TextField motherNameTextField=new TextField();
        motherNameTextField.setPromptText("Mother's name");
        GridPane.setConstraints(motherNameTextField,1,6);
        gridPane.getChildren().addAll(motherNameLabel,motherNameTextField);

        //Gender Label
        Label genderLabel=new Label("Gender:");
        genderLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(genderLabel,0,8);

        //Gender Radio Button
        final ToggleGroup group = new ToggleGroup();
        RadioButton maleGenderRadio=new RadioButton("Male");
        maleGenderRadio.setToggleGroup(group);
        GridPane.setConstraints(maleGenderRadio,1,8);
        RadioButton femaleGenderRadio=new RadioButton("Female");
        femaleGenderRadio.setToggleGroup(group);
        GridPane.setConstraints(femaleGenderRadio,2,8);
        gridPane.getChildren().addAll(genderLabel,maleGenderRadio,femaleGenderRadio);

        //Birthday label
        Label birthdayLabel=new Label("Birthday:");
        birthdayLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(birthdayLabel,0,10);

        //Birthday Text Field
        TextField birthdayTextField=new TextField();
        birthdayTextField.setPromptText("dd/mm/yyyy");
        GridPane.setConstraints(birthdayTextField,1,10);
        gridPane.getChildren().addAll(birthdayTextField,birthdayLabel);

        //Blood Group label
        Label bloodGroupLabel=new Label("Blood Group:");
        bloodGroupLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(bloodGroupLabel,0,12);

        //Blood Group Text Field
        TextField bloodGroupTextField=new TextField();
        bloodGroupTextField.setPromptText("Blood Group");
        GridPane.setConstraints(bloodGroupTextField,1,12);
        gridPane.getChildren().addAll(bloodGroupLabel,bloodGroupTextField);

        //Division
        Label divisionLabel=new Label("Division:");
        divisionLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(divisionLabel,0,14);

        //Division choiceBox
        ChoiceBox<String> divisionChoiceBox=new ChoiceBox<>();
        divisionChoiceBox.getItems().addAll("Barishal","Chattogram","Dhaka","Khulna","Mymensingh","Rajshahi","Rangpur","Sylhet");
        GridPane.setConstraints(divisionChoiceBox,1,14);
        divisionChoiceBox.setValue("Khulna");
        gridPane.getChildren().addAll(divisionChoiceBox,divisionLabel);

        //District label
        Label districtLabel=new Label("District:");
        districtLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(districtLabel,0,16);

        //District Text Field
        TextField districtTextField=new TextField();
        districtTextField.setPromptText("District");
        GridPane.setConstraints(districtTextField,1,16);
        gridPane.getChildren().addAll(districtTextField,districtLabel);

        //Post Code Label
        Label PostcodeLabel=new Label("Postcode:");
        PostcodeLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(PostcodeLabel,6,2);

        //Post Code Text Field
        TextField postcodeTextField=new TextField();
        postcodeTextField.setPromptText("Postcode");
        GridPane.setConstraints(postcodeTextField,7,2);
        gridPane.getChildren().addAll(PostcodeLabel,postcodeTextField);

        //Contact Number label
        Label ContactLabel=new Label("Contact No.:");
        ContactLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(ContactLabel,6,4);

        //Contact Number Text Field
        TextField contactNumberTextField=new TextField();
        contactNumberTextField.setPromptText("Contact number");
        GridPane.setConstraints(contactNumberTextField,7,4);
        gridPane.getChildren().addAll(contactNumberTextField,ContactLabel);

        //Email label
        Label emailLabel=new Label("Email:");
        emailLabel.setFont(new Font("Arial",17));
        GridPane.setConstraints(emailLabel,6,6);

        //Email Text Field
        TextField emailTextField=new TextField();
        emailTextField.setPromptText("email");
        GridPane.setConstraints(emailTextField,7,6);
        gridPane.getChildren().addAll(emailLabel,emailTextField);

        //password

        Label password = new Label("Password");
        password.setFont(new Font("Arial",17));
        GridPane.setConstraints(password,6,7);

        TextField PasswordText = new TextField();
        PasswordText.setPromptText("Password");
        GridPane.setConstraints(PasswordText,7,7);
        gridPane.getChildren().addAll(password,PasswordText);

        //Submit Button
        Button submitButton=new Button("Submit");
        GridPane.setConstraints(submitButton,7,11);
        DropShadow shadow = new DropShadow();

        //Adding the shadow when the mouse cursor is on
        submitButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                submitButton.setEffect(shadow);
            }
        });

        //Removing the shadow when the mouse cursor is off
        submitButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                submitButton.setEffect(null);
            }
        });
            Information obj1 = new Information();
        //submit Button Action Event
        submitButton.setOnAction(e->{
            totalString="";
            stringUserName=getString(userNameTextField);
            obj1.setName(stringUserName);
            totalString+=stringUserName+"#";
            stringFatherName=getString(fatherNameTextField);
            obj1.setFatherName(stringFatherName);
            totalString+=stringFatherName+"#";
            stringMotherName=motherNameTextField.getText();
            obj1.setMotherNamae(stringMotherName);
            totalString+=stringMotherName+"#";
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String toogleGroupValue = selectedRadioButton.getText();
            obj1.setGender(toogleGroupValue);
            totalString += toogleGroupValue+"#";
            stringBirthday=birthdayTextField.getText();
            obj1.setBirthDay(stringBirthday);
            totalString+=stringBirthday+"#";
            stringBloodGroup=bloodGroupTextField.getText();
            obj1.setBlood(stringBloodGroup);
            totalString+=stringBloodGroup+"#";
            stringDivisionChoiceBoxValue=divisionChoiceBox.getValue();
            obj1.setDivision(stringDivisionChoiceBoxValue);
            totalString+=stringDivisionChoiceBoxValue+"#";
            stringDistrictName=districtTextField.getText();
            obj1.setDistrict(stringDistrictName);
            totalString+=stringDistrictName+"#";
            stringPostCode=postcodeTextField.getText();
            obj1.setPostcode(stringPostCode);
            totalString+=stringPostCode+"#";
            stringContactNumber=contactNumberTextField.getText();
            obj1.setContactNo(stringContactNumber);
            totalString+=stringContactNumber+"#";
            stringemail=emailTextField.getText();
            obj1.setEmail(stringemail);
            totalString+=stringemail+"#";
            String pass = PasswordText.getText();
            totalString+=pass+"#";
            obj1.setPassWord(pass);
            regID = stringBirthday;
            regID = regID.replace("/","");
            regID += Integer.toString(vector.size());
            System.out.println("regID = "+regID);
            obj1.setRegID(regID);
            totalString += regID;

            int temp = new MessageWindow().display();
            int what =1;

                what = new AdminPermission(obj1).permission();

            //int what = new AdminClient(obj1).communication();
            if (what == 2) {
                window.close();
                VoterData voterData = new VoterData(totalString);
                mp.put(regID, vector.size());
                vector.add(obj1);
                new AdminPermissionShowWindow("Registration Completed!").Display(regID,1);

            }
            else {
                new AdminPermissionShowWindow("Registration Denied!").Display(regID,2);
            }
        });

        //Add All
        gridPane.getChildren().addAll(label,fatherNameTextField,fatherNameLabel,userNameLabel,userNameTextField,submitButton);

        //Set In The Scene
        Scene scene = new Scene(gridPane,1000,600);
        scene.getStylesheets().add("viper.css");
        window.setScene(scene);
        window.showAndWait();
    }

    String getString(TextField text)
    {
        return text.getText();
    }
}
