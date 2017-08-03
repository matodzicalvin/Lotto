package com.example.codetribe.lotto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button play;
    Button res;
    Button display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        play= (Button) findViewById(R.id.button2);
        res= (Button) findViewById(R.id.button3);
        display= (Button) findViewById(R.id.button5);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(i);
            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent z =new Intent(Main2Activity.this,MainActivity.class) ;
                startActivity(z);
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,Main4Activity.class);
                startActivity(i);
            }
        });
    }
}
