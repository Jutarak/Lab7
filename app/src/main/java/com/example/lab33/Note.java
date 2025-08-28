package com.example.lab33;

public abstract class Note {
              //Attribute
    public String title;
    public String createdDate;
    //getter
    public String getTitle() {
        return title;
    }
        //setter
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    //getter
    public String getCreatedDate() {
        return createdDate;
    }
    //setter

    public void setCreatedDate(String newCreatedDate) {
        this.createdDate = newCreatedDate;
    }

    //Method
    abstract public String getSummary();
        //System.out.println (title=":"+textContent+"("+createdDate+")");
    }

