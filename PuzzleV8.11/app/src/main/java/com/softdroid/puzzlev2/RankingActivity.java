package com.softdroid.puzzlev2;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {
    ListView listView; //Listview para introducir y mostrar la lista
    ArrayList<Puntuacion> lista;// ArrayList donde guardamos los registros de la bd
    ArrayList<String> listaRanking;

    ArrayAdapter adapter; //adaptador para mostrar los datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        listView = (ListView) findViewById(R.id.lista); //vinculamos la variable listview con la listview del layout
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(RankingActivity.this);//Crea conexión y BD

        lista = adminSQLiteOpenHelper.getPuntuacion(); //asignamos en el arraylist lista el resultado de la llamada al método getPuntuacion
        //Log.d("milista", lista);
        obtenerLista();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaRanking); //creamos un adaptador
        listView.setAdapter(adapter); //enviamos la listview con el adaptader para mostrar su contenido


    }

    private void obtenerLista(){
        listaRanking = new ArrayList<String>();
        for (int i=0; i<lista.size(); i++){
            listaRanking.add(String.valueOf(i+1) + "  " + lista.get(i).getName() + "  time: " + lista.get(i).getTime());
;        }

    }
}

