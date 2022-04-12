package Roagen7.com.github.symulacja.organizmy;

import Roagen7.com.github.pomocnicze.Wektor2d;

import java.awt.*;

import static java.lang.Math.PI;
import static java.lang.Math.random;

public class Zwierze extends Organizm{


    public Zwierze(Wektor2d polozenie, int sila, int inicjatywa){

        super(polozenie,sila,inicjatywa);

    }


    @Override
    public String toString() {
        return "ZWIERZE";
    }

    @Override
    public void akcja() {

        losowyRuch(1);
    }

    @Override
    public void kolizja() {

        Organizm drugi = swiat.getKolidujacy(this);
        if(drugi == null) return;

        if(drugi.toString().equals(toString())){

            rozmnozSie((Zwierze) drugi);

        } else {

            walcz(drugi);

        }

    }

    @Override
    public Color rysowanie() {
        return new Color(255,0,0);
    }

    @Override
    public void nowaTura() {

        rozmnozylSie = false;

    }

    @Override
    protected Zwierze kopia(){

        return new Zwierze(polozenie,sila,inicjatywa);

    }


    protected void losowyRuch(int zasieg){

        int[] koordynaty = {-1 * zasieg, 0, zasieg};

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

            wczesniejszePolozenie = new Wektor2d(polozenie.getY(),polozenie.getX());
            polozenie.dodajEq(przemieszczenie);

        }


    }

    private boolean rozmnozylSie = false;
    private Wektor2d wczesniejszePolozenie;

    void walcz(Organizm drugi){

        if(getSila() < drugi.getSila()){

            if(czyOdbilAtak(drugi)){

                cofnijSie();
                return;

            }

            swiat.getDziennik().wpisz(drugi.toString() + " zjada " + toString());

            zabij();
            dodajModyfikator(drugi);

        } else {

            if(drugi.czyOdbilAtak(this)){

                cofnijSie();
                return;

            }

            swiat.getDziennik().wpisz(toString() + " zjada " + drugi.toString());

            drugi.zabij();
            drugi.dodajModyfikator(this);

        }


    }

    void rozmnozSie(Zwierze drugi){

        if(drugi.getWiek() == 0){

            return;

        }



        Organizm org = kopia();

        cofnijSie();

        Wektor2d miejsceNarodzin = swiat.getWolnePoleObok(drugi.getPolozenie());
        if(miejsceNarodzin.equals(drugi.getPolozenie()) || rozmnozylSie || drugi.rozmnozylSie){

                return;

        }

        org.setPolozenie(miejsceNarodzin);
        org.setWiek(0);

        swiat.addOrganizm(org);

        rozmnozylSie = true;
        drugi.rozmnozylSie = true;





    }

    void cofnijSie(){

        setPolozenie(wczesniejszePolozenie);


    }



}
