package Roagen7.com.github.symulacja.organizmy;

import Roagen7.com.github.pomocnicze.Wektor2d;

public class Zwierze extends Organizm{


    public Zwierze(Wektor2d polozenie, int sila, int inicjatywa){

        super(polozenie,sila,inicjatywa);

    }


    @Override
    public String toString() {
        return "z";
    }

    @Override
    public void akcja() {

    }

    @Override
    public void kolizja() {

    }

    @Override
    public void nowaTura() {

    }


    protected void losowyRuch(int zasieg){


    }

    protected void zmienPolozenie(Wektor2d przemieszczenie){


    }

    private boolean rozmnozylSie = false;
    private Wektor2d wczesniejszePolozenie;

    void walcz(Organizm drugi){


    }

    void rozmnozSie(Zwierze drugi){


    }

    void cofnijSie(){


    }



}
