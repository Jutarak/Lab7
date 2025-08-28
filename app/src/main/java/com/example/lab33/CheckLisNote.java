package com.example.lab33;

import java.util.List;

public class CheckLisNote extends Note{
    private List<String> items ;

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
