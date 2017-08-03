package com.example.codetribe.lotto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView view;
    Button generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view= (TextView) findViewById(R.id.textView);
        generate= (Button) findViewById(R.id.button);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lotto();
            }
        });
    }


    void lotto(){

        long getCommonNum = System.nanoTime();

        ArrayList<Integer> win = new ArrayList<>();
        ArrayList<Integer> winNum = new ArrayList<>();
        Random r = new Random();

        for( int i = 1;i<49;i++){

            win.add(i);

        }

        Collections.shuffle(win, new Random(getCommonNum));

        for(int i =0; i < 6; i++){
            winNum.add(win.get(i));
        }

        Collections.sort(winNum);
        view.setText(""+winNum);

    }
}
