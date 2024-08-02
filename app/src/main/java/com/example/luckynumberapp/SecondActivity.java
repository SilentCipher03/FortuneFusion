package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView textview;
    TextView textview2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textview = findViewById(R.id.textview);
        textview2 = findViewById(R.id.textview2);
        btn = findViewById(R.id.btn);

        Intent i = getIntent();
        String username = i.getStringExtra("name");

        //Display lucky number

        int random_num = RandomNum();
        textview2.setText(String.valueOf(random_num));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedata(username, random_num);
            }
        });


    }

    public static int RandomNum(){
        Random random = new Random();

        int upper_limit = 1000;

        int finalramdomNumGenerated = random.nextInt(upper_limit);
        return finalramdomNumGenerated;
    }

    public void sharedata(String username, int randomnum){

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //Additional Info
        i.putExtra(Intent.EXTRA_SUBJECT, username+ "got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "Her Lucky number is "+randomnum);

        startActivity(Intent.createChooser(i, "Choose a Platform"));
    }
}