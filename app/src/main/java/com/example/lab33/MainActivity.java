package com.example.lab33;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });
    }

    public static void main(String[] args) {
        Note noteA = new Note();
        noteA.title = "japan";
        noteA.context = "Gotchi";
        noteA.createdDate = 12765;
        noteA.getSummary();

        Note noteB = new Note();
        noteB.title = "mommi";
        noteB.context = "mom";
        noteB.createdDate = 12865;
        noteB.getSummary();

        User usera = new User();
        usera.Name ="salmon";
        usera.ID = 10163;
        usera.Take_Notes();

        User userb = new User();
        userb.Name ="katha";
        userb.ID = 11163;
        userb.Take_Notes();





    }
}