package com.example.codetribe.lotto;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    EditText one;
    EditText two;
    EditText three;
    EditText four;
    EditText five;
    EditText six;
    Button play;
    TextView thanks;
    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        one= (EditText) findViewById(R.id.editText);
        two= (EditText) findViewById(R.id.editText2);
        three= (EditText) findViewById(R.id.editText3);
        four= (EditText) findViewById(R.id.editText4);
        five= (EditText) findViewById(R.id.editText5);
        six= (EditText) findViewById(R.id.editText6);
        thanks= (TextView) findViewById(R.id.textView3);

        play= (Button) findViewById(R.id.button4);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if(one.length()==0){
                    one.setError("This field can't be empty");
                    one.requestFocus();
                }
                else if (Integer.valueOf(one.getText().toString())<1||Integer.valueOf(one.getText().toString())>49){
                    Toast.makeText(getApplicationContext(),"Use Values from 1 to 49",Toast.LENGTH_LONG).show();
                }

                else if(two.length()==0){
                    two.setError("This field can't be empty");
                    two.requestFocus();
                }

                 else if (Integer.valueOf(two.getText().toString())<1||Integer.valueOf(two.getText().toString())>49){
                    Toast.makeText(getApplicationContext(),"Use Values from 1 to 49",Toast.LENGTH_LONG).show();
                }
                else if(three.length()==0){
                    three.setError("This field can't be empty");
                    three.requestFocus();
                }
                else if (Integer.valueOf(three.getText().toString())<1||Integer.valueOf(three.getText().toString())>49){
                    Toast.makeText(getApplicationContext(),"Use Values from 1 to 49",Toast.LENGTH_LONG).show();
                }

                else if(four.length()==0){
                    four.setError("This field can't be empty");
                    four.requestFocus();
                }
                else if (Integer.valueOf(four.getText().toString())<1||Integer.valueOf(four.getText().toString())>49){
                    Toast.makeText(getApplicationContext(),"Use Values from 1 to 49",Toast.LENGTH_LONG).show();
                }

                else if(five.length()==0){
                    five.setError("This field can't be empty");
                    five.requestFocus();
                }
                else if (Integer.valueOf(five.getText().toString())<1||Integer.valueOf(five.getText().toString())>49){
                    Toast.makeText(getApplicationContext(),"Use Values from 1 to 49",Toast.LENGTH_LONG).show();
                }


                else if(six.length()==0){
                    six.setError("This field can't be empty");
                    six.requestFocus();
                }
                else if (Integer.valueOf(six.getText().toString())<1||Integer.valueOf(six.getText().toString())>49){
                    Toast.makeText(getApplicationContext(),"Use Values from 1 to 49",Toast.LENGTH_LONG).show();
                }

                else{
                    CreateDatabase();
                    AddLotto();
                }


            }
        });

    }




    protected void CreateDatabase(){
        db=openOrCreateDatabase("lottoDB", Context.MODE_PRIVATE, null);
        // db=openOrCreateDatabase("PersonsDB",Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS lotto(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,first INTEGER,second INTEGER,third INTEGER,fourth integer, fifth INTEGER ,sixth INTEGER );");
    }
    public void AddLotto () {

        String first = one .getText().toString().trim();
        String second = two.getText().toString().trim();
        String third = three.getText().toString().trim();
        String fourth = four.getText().toString().trim();
        String fifth = five.getText().toString().trim();
        String sixth = six.getText().toString().trim();
        String query = "INSERT INTO lotto (first,second,third,fourth,fifth,sixth) VALUES('"+first+"', '"+second+"', '"+third+"', '"+fourth+"', '"+fifth+"', '"+sixth+"');";
        db.execSQL(query);
        Toast.makeText(getApplicationContext(),"Saved Successfully", Toast.LENGTH_LONG).show();
        thanks.setVisibility(View.VISIBLE);

    }


}

