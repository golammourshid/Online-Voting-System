package com.com.listShow;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {



    SimpleStringProperty registrationNumber;
    SimpleStringProperty name;
    SimpleStringProperty postCode;
    SimpleStringProperty email;
    SimpleIntegerProperty serialNumber;
    SimpleStringProperty Divison;
    //SimpleStringProperty totalNumber;

    Person(int serialNumber,String regNumber, String name, String postCode, String email,String Divison) {
        this.serialNumber=new SimpleIntegerProperty(serialNumber);
        this.registrationNumber = new SimpleStringProperty(regNumber);
        this.name = new SimpleStringProperty(name);
        this.postCode = new SimpleStringProperty(postCode);
        this.email = new SimpleStringProperty(email);
        this.Divison = new SimpleStringProperty(Divison);
        //this.totalNumber = new SimpleStringProperty(totalNumber);
    }

    public int getSerialNumber() {
        return serialNumber.get();
    }

    //public String gettotalNumber(){ return totalNumber.get();}

    public String getName() {
        return name.get();
    }
    public String getDivison(){ return Divison.get();}

    public String getRegistrationNumber() {
        return registrationNumber.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getPostCode() {
        return postCode.get();
    }
}
