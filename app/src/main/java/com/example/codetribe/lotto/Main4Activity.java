package com.example.codetribe.lotto;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    private static final String SELECT_SQL = "SELECT * FROM lotto";

    private SQLiteDatabase db;
    private ProgressDialog pDialog;
    private Cursor c;

    Button btnBack;
    Button btnNext;
    Button btnPrev;

    TextView a;
    TextView b;
    TextView ci;
    TextView d;
    TextView e;
    TextView f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        openDatabase();

        // textViewid= (TextView) findViewById(R.id.textViewId);


        btnBack = (Button) findViewById(R.id.button);
        btnNext = (Button) findViewById(R.id.button5);
        btnPrev = (Button) findViewById(R.id.button6);
        a= (TextView) findViewById(R.id.textView4);
        b= (TextView) findViewById(R.id.textView5);
        ci= (TextView) findViewById(R.id.textView6);
        d= (TextView) findViewById(R.id.textView7);
        e= (TextView) findViewById(R.id.textView8);
        f= (TextView) findViewById(R.id.textView9);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movePrev();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveNext();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pDialog = new ProgressDialog(Main4Activity.this);
                pDialog.setTitle("Loading menu...");
                pDialog.setMessage("Please Wait...");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(true);
                pDialog.show();
                pDialog.setMax(10000);

                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });

        c = db.rawQuery(SELECT_SQL, null);
        c.moveToFirst();
        showRecords();
    }

    protected void openDatabase() {
        db = openOrCreateDatabase("lottoDB", Context.MODE_PRIVATE, null);
    }

    protected void showRecords() {

        // String id = c.getString(0);
        // textViewid.setText(id);

        String name = c.getString(1);
        a.setText(name);

        String c1 = c.getString(2);
        b.setText(c1);

        String g = c.getString(3);
        ci.setText(g);

        String cal = c.getString(4);
        d.setText(cal);

        String gra = c.getString(5);
        e.setText(gra);

        String grad = c.getString(6);
        f.setText(grad);




    }

    protected void moveNext() {
        if (!c.isLast()) {
            c.moveToNext();

            showRecords();
        }
        else if(c.isLast()){
            Toast.makeText(getApplication(),"this is first record",Toast.LENGTH_LONG).show();

        }
    }

    protected void movePrev() {
        if (!c.isFirst()) {
            c.moveToPrevious();

            showRecords();
        }
        else if(c.isFirst()){
            Toast.makeText(getApplication(),"this is last record",Toast.LENGTH_LONG).show();

        }
    }

}
