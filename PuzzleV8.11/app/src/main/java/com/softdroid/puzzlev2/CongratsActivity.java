package com.softdroid.puzzlev2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CongratsActivity extends PuzzleActivity{



    EditText editText;
    Button submitButton;
    Button menu;
    String nombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        editText = (EditText) findViewById(R.id.editText);

        submitButton = (Button) findViewById(R.id.button);

        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // get the data with the
                        // "editText.text.toString()"
                        nombre = editText.getText().toString();

                        // check whether the retrieved data is
                        // empty or not based on the emptiness
                        // provide the Toast Message
                        if (nombre.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Please Enter your AKA", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Record saved!", Toast.LENGTH_SHORT).show();
                            insertDB();
                            Intent intent = new Intent(CongratsActivity.this, MenuActivity.class);
                            startActivity(intent);
                        }
                    }
                });

        menu = (Button) findViewById(R.id.menu);
        menu.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CongratsActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


    }
    public void insertDB(){
        String time = getIntent().getStringExtra("tiempo");
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(CongratsActivity.this);//Crea conexión y BD
        adminSQLiteOpenHelper.insertar(nombre, time);//Insertamos datos en BD
    }

}
