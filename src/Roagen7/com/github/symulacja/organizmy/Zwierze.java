package Roagen7.com.github.symulacja.organizmy;

import Roagen7.com.github.pomocnicze.Wektor2d;

import java.awt.*;

import static java.lang.Math.random;

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

        losowyRuch(1);
    }

    @Override
    public void kolizja() {

    }

    @Override
    public Color rysowanie() {
        return new Color(255,0,0);
    }

    @Override
    public void nowaTura() {

    }


    protected void losowyRuch(int zasieg){

        int koordynaty[] = {-1 * zasieg, 0, zasieg};

        Wektor2d przemieszczenie = new Wektor2d(0,0);
        Wektor2d wczesniejsze = new Wektor2d(polozenie.getY(),polozenie.getX());

        do {


            int randX = koordynaty[(int) (random() * 3)];
            int randY = koordynaty[(int) (random() * 3)];

            przemieszczenie = new Wektor2d(randY,randX);

            zmienPolozenie(przemieszczenie);

        } while(wczesniejsze.equals(polozenie));

    }

    protected void zmienPolozenie(Wektor2d przemieszczenie){

        if(!polozenie.dodaj(przemieszczenie).pozaGranicami(swiat.getWysokosc(),swiat.getSzerokosc())){

            wczesniejszePolozenie = polozenie;
            polozenie.dodajEq(przemieszczenie);

        }


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
