package com.example.lab33;

import java.util.List;

public class CheckLisUser extends User {
    private List<String> UserID;

    //getter
    public List<String> getUserID() {
        return UserID;
    }

    //setter
    public void setItems(List<String> newUserID) {
        this.UserID = newUserID;
    }

    public String getSummary() {
        return Name + ":(" + ID + " )";
        //System.out.println (Name = ":" + textName + "(" + ID + ")");
    }
}