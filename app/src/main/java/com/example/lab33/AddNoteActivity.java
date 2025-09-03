package com.example.lab33;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    Button addBack;
    Button addButton2;
    Button addcheck;
    EditText title, textContent, name, id;
    TextView display, display1 , display2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addBack = findViewById(R.id.back);
        addBack.setOnClickListener(new View.OnClickListener() {//event listener
            @Override
            public void onClick(View view) {
                System.out.println("Click!!");
                Intent addBack = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(addBack);
            }
        });
        //old code


        addButton2 = findViewById(R.id.button2);
        title = findViewById(R.id.editTextText);
        textContent = findViewById(R.id.editTextText2);
        display = findViewById(R.id.textView3);
        display1 = findViewById(R.id.textView4);
        display2 = findViewById(R.id.textView5);
        addcheck = findViewById(R.id.addChack);
        name = findViewById(R.id.editTextText3);
        id = findViewById(R.id.editTextText4);

        addButton2.setOnClickListener(new View.OnClickListener() {//event listener
            @Override
            public void onClick(View view) {
                //get data from (EditText)
                String strOfTitle = title.getText().toString();
                String strOfContent = textContent.getText().toString();
                String stOfDate = new Date().toString();
                String strOname = name.getText().toString();
                String strOid = id.getText().toString();
                //set data to Text clas
                TextNote note1 = new TextNote();
                note1.setTitle(strOfTitle);

                note1.setTextContent(strOfContent);

                note1.createdDate = stOfDate;
                User user1 = new TextUser();
                user1.setName(strOname);
                user1.setID(strOid);

                //show note on TextView
                display.setText(note1.getSummary());
                display2.setText(user1.getSummary());
            }

        });
        addcheck.setOnClickListener(new View.OnClickListener() {//event listener
            @Override
            public void onClick(View view) {
                String strOfTitle = title.getText().toString();
                String stOfDate = new Date().toString();

                CheckLisNote note1 = new CheckLisNote();
                note1.setTitle(strOfTitle);

                note1.createdDate = stOfDate;

                display1.setText(note1.getSummary());


            }
        });

    }
}

