package com.softdroid.puzzlev2;


/*
    Esta clase representa cada una de las puntuaciones que se obtienen en el juego.
 */
public class Puntuacion {


    private  int id;
    private String name;
    private String time;


    @Override
    public String toString() {
        return name;
    }


    public Puntuacion() {
    }

    public Puntuacion(int id, String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public String getName() {

        return name;
    }

    public void setName(String nombre) {

        this.name = name;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {

        this.time = time;
    }
    public String toADouble() {

        return time;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}