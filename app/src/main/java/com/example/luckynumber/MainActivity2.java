package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
TextView textView21,textView22;
Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView21 =findViewById(R.id.textView21);
        textView22=findViewById(R.id.textView22);
        button2 =findViewById(R.id.button2);

        Intent i = getIntent();
        String username = i.getStringExtra("name");

        int numberGen = randomNumber();
        textView22.setText(""+numberGen);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(username,numberGen);
            }
        });
    }
    public int randomNumber(){
        Random random = new Random();
        int upperLimit = 1000;
        return random.nextInt(upperLimit);

    }
    public void shareData(String username,int numberGen){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,username +" got Lucky today");
        i.putExtra(Intent.EXTRA_SUBJECT,"His Lucky number is : "+numberGen);

        startActivity(Intent.createChooser(i,"Choose a Platform"));
    }
}