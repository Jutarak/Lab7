package com.example.lab33;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    ImageView logo;
    Button addbrowse;
    ProgressBar progressBar;


    @SuppressLint("MissingInflatedId")
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

        addButton = findViewById(R.id.button);
        logo = findViewById(R.id.imageView);
        logo.setImageResource(R.drawable.aaa);


        addButton.setOnClickListener(new View.OnClickListener() {//event listener
            @Override
            public void onClick(View view) {
                System.out.println("Click!!");
                Intent addNoteAct = new Intent(getApplicationContext(), AddNoteActivity.class);
                startActivity(addNoteAct);
            }
        });
        addbrowse = findViewById(R.id.button3);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        //load data from DB
        addbrowse.setOnClickListener(new View.OnClickListener() {//event listener
            @Override
            public void onClick(View view) {
                //show progress bar
                progressBar.setVisibility(View.VISIBLE);

                //create thread
                new Thread(()->{

                    //2.1 delay 2 seconds
                   try {
                       Thread.sleep(2000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

                    // 2.2 load data from DB

                    //2.3 back to main thread
                    runOnUiThread(()->{
                        progressBar.setVisibility(View.GONE);

                        //2.4 go to Browse Note Activity

                        Intent BrowseNoteAct = new Intent(getApplicationContext(), BrowseNoteActivity.class);
                        startActivity(BrowseNoteAct);
                    });

                }).start();




            }
        });
    }
}



    //public static void main(String[] args) {
        //Note noteA = new Note();
        //noteA.title = "japan";
        //noteA.content = "Gotchi";
        //noteA.createdDate = 12765;
        //noteA.getSummary();

        //TextNote textNote1 = new TextNote();
        //textNote1.title = "japan";
        //textNote1.textContent = "Gotchi";

        //Note noteB = new Note();
        //noteB.title = "mommi";
        //noteB.content = "mom";
        //noteB.createdDate = 12865;
        //noteB.getSummary();



        //User userb = new User();
        //userb.Name ="katha";
        //userb.ID = 11163;
        //userb.getSummary();


     //}
