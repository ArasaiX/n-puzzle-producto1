package com.softdroid.puzzlev2;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.notification.NotificationListenerService;

import androidx.annotation.Nullable;

import com.softdroid.puzzlev2.Puntuacion;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String PUNTUACION_TABLE_CREATE = "CREATE TABLE puntuacion(_id INTEGER PRIMARY KEY AUTOINCREMENT, name String, time String)"; // String que ejecuta la tabla
    private static final String DB_NAME = "puntuacion.sqlite"; // nombre de la tabla de datos
    //  private static final Int DB_TIME = "puntuacion.sqlite";
    private static final int DB_VERSION = 1; // version
    private SQLiteDatabase db;

    public AdminSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db=this.getWritableDatabase();
    }

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PUNTUACION_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertar(String name, String time){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("time", time);
        db.insert("puntuacion", null, cv);
    }

    //Borrar  tabla
    public void borrar(int id){
        String[] args = new String[]{String.valueOf(id)};
        db.delete("puntuacion", "_id=?", args);
    }

    //Obtener la lista de puntuacion en la base de datos
    public ArrayList<Puntuacion> getPuntuacion(){

        //Creamos el cursor
       ArrayList<Puntuacion> lista=new ArrayList<Puntuacion>();
        Cursor c = db.rawQuery("SELECT _id, name, time FROM puntuacion ORDER BY time ASC", null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                //Asignamos el valor en nuestras variables para crear un nuevo objeto Ranking
                @SuppressLint("Range") int id = c.getInt(c.getColumnIndex("_id"));
                @SuppressLint("Range") String name = c.getString(c.getColumnIndex("name"));
                @SuppressLint("Range") String time = c.getString(c.getColumnIndex("time"));

                Puntuacion com =new Puntuacion(id,name,time);
                //Añadimos el registro en la lista
                lista.add(com);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }

}
