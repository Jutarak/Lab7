package com.example.lab33;

public abstract class User {
    public String Name;
    public String ID;

    //getter
    public String getName() {
        return Name;
    }
    public String getID() {
        return ID;
    }
    public void setName(String newName) {
        this.Name = newName;
    }
    public void setID(String newID) {
        this.ID = newID;
    }
    //M
    abstract public String getSummary();
    //usera.Take_Notes();
    }

