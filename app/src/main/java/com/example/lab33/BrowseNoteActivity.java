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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BrowseNoteActivity extends AppCompatActivity {

    Button addsearch,back2;
    ProgressBar progressBar2;
    TextView display2;
    EditText editTextText5;
    TextView showNote , showNoteFromAPI;



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
        back2 = findViewById(R.id.button4);
        back2.setOnClickListener(new View.OnClickListener() {//event listener
            @Override
            public void onClick(View view) {
                System.out.println("Click!!");
                Intent addBack = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(addBack);
            }
        });

        showNote = findViewById(R.id.textView6);
        showNoteFromAPI = findViewById(R.id.textView7);

        //context.context=viwe.getContext();
        //load data from db
        Executors.newSingleThreadExecutor().execute(()->{
            List<NoteEntity>entities = AppDatabase.getInstance(getApplicationContext()).noteDao().getAll();
            List<Note>notes = new ArrayList<>();
            for (NoteEntity e : entities){
                notes.add(NoteMapper.fromEntity(e));
            }

            //display on UI thread
            runOnUiThread(()  -> {
                StringBuilder sb = new StringBuilder();
                for (Note n : notes){
                    sb.append(n.getSummary()).append("\n");
                }
                showNote.setText(sb.toString());
            });
        });

        //load from API
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("https://jsonpiaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<TextNote>>call = apiService.getTextNote();

        call.enqueue(new Callback<List<TextNote>>() {
            @Override
            public void onResponse(Call<List<TextNote>> call, Response<List<TextNote>> response) {
                if (!response.isSuccessful()){
                    showNoteFromAPI.setText("Error Code:"+response.code());
                    return;
                }
                List<TextNote>notes = response.body();
                StringBuilder builder = new StringBuilder();
                for (TextNote n : notes){
                    builder.append("Title: ").append(n.getTitle()).append("\n")
                            .append("Body: ").append(n.getTextContent()).append("\n\n");
                }
                showNoteFromAPI.setText(builder.toString());
            }

            @Override
            public void onFailure(Call<List<TextNote>> call, Throwable t) {
                showNoteFromAPI.setText("Failad: "+t.getMessage() );

            }
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




