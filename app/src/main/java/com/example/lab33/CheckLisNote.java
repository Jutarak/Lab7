package com.example.lab33;

import java.util.List;

public class CheckLisNote extends Note{
    private List<String> items ;

    public CheckLisNote(String title, String createdDate, List<String> items) {
        this.title = title;
        this.createdDate = createdDate;
        this.items = items;
    }

    public CheckLisNote() {

    }


    //getter
    public List<String> getItems() {
        return items;
    }

    //setter
    public void setItems(List<String> newTitle) {
        this.items = newTitle;
    }


    public String getSummary(){
        //String strItem = //Loop for get data from List
        //return title=":"+strItem+"("+createdDate+")";
        return title=":("+createdDate+")";
    }


}
