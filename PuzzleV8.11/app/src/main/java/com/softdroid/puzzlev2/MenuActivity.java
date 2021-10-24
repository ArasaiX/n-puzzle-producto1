package com.softdroid.puzzlev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLInput;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    Button btn_vArcade, btn_ayuda, btn_ranking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn_vArcade = (Button) findViewById(R.id.btn_arcade);
        btn_ayuda = (Button) findViewById(R.id.btn_ayuda);
        btn_ranking = (Button) findViewById(R.id.btn_ranking);

        btn_vArcade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
            Intent intent = new Intent(MenuActivity.this, AyudaActivity.class);
            startActivity(intent);
        }
        });

        btn_ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, RankingActivity.class);
                startActivity(intent);
            }
        });
    }
}
