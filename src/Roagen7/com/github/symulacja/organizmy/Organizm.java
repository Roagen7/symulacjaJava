package Roagen7.com.github.symulacja.organizmy;

import Roagen7.com.github.pomocnicze.Wektor2d;

abstract public class Organizm {


    public Wektor2d getPolozenie(){

        return polozenie;

    }

    public void setPolozenie(Wektor2d polozenie){

        this.polozenie = polozenie;

    }


    public int getInicjatywa(){

        return inicjatywa;

    }

    public int getSila(){

        return sila;

    }

    public void setSila(int sila){

        this.sila = sila;

    }

    public boolean isZywy(){

        return zywy;

    }

    public void zabij(){

        zywy = false;

    }

    public int getWiek(){

        return wiek;

    }

    public void dodajModyfikator(Organizm organizm) {


    }

    public boolean czyOdbilAtak(Organizm org){

        return false;
    }

    public boolean czyUciekl(){

        return false;

    }

    public boolean ucieczka(){

        //TODO ucieczka z pola(dla antylopy)

        return false;

    }



    @Override
    abstract public String toString();

    public abstract void akcja();
    public abstract void kolizja();
    public abstract void nowaTura();



    protected int sila;
    protected int inicjatywa;
    protected int wiek;
    protected boolean zywy = true;

    protected Wektor2d polozenie;

    protected Organizm(Wektor2d polozenie, int sila, int inicjatywa){

        this.polozenie = polozenie;
        this.sila = sila;

    }


    protected boolean czyMaDobryWech(){

        return false;

    }



}
