package com.example.lab33;

public abstract class Note {
              //Attribute
    protected User owner;
    public String title;
    public String createdDate;
    //getter
    public User getOwner(){
        return owner;
    }
    public String getTitle() {
        return title;
    }
        //setter
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    //getter
    public  void setOwner(User owner){
        this.owner = owner ;
    }
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

