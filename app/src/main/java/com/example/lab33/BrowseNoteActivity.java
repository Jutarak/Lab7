package com.example.lab33;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class BrowseNoteActivity extends AppCompatActivity {

    Button addsearch;
    ProgressBar progressBar2;
    TextView display2;
    EditText editTextText5;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextText5 = findViewById(R.id.editTextText5);
        display2 = findViewById(R.id.display2);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.GONE);
        addsearch = findViewById(R.id.addsearch);
        //event listener
        addsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show progress bar
                progressBar2.setVisibility(View.VISIBLE);

                //create thread
                new Thread(() -> {

                    //2.1 delay 2 seconds
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 2.2 load data from DB

                    //2.3 back to main thread
                    runOnUiThread(() -> {
                        progressBar2.setVisibility(View.GONE);
                        display2.setText("ไม่พบข้อมูล");

                        //2.4 go to Browse Note Activity

                    });

                }).start();
            }
        });
    }
}




