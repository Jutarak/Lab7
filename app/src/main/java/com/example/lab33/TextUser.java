package com.example.lab33;

public class TextUser extends User {
    //Att
    private String textName;

    //getter
    public String getTextName() {
        return textName;
    }

    //setter
    public void setTextName(String newName) {
        this.textName = newName;
    }

    public String getSummary() {
        return Name+ ":(" + ID +" )";
        //System.out.println (Name = ":" + textName + "(" + ID + ")");
    }
}
