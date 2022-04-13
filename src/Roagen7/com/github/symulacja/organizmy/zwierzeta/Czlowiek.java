package Roagen7.com.github.symulacja.organizmy.zwierzeta;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Zwierze;

import java.awt.*;

public class Czlowiek extends Zwierze {

    public static final int SILA = 5;
    public static final int INICJATYWA = 4;



    public Czlowiek(Wektor2d polozenie) {
        super(polozenie, SILA, INICJATYWA);
    }

    @Override
    public void akcja(){

        int zasieg = 1;

        switch(swiat.popRuch()){

            case GORA:
                zmienPolozenie(new Wektor2d(zasieg * -1, 0));
                break;

            case DOL:
                zmienPolozenie(new Wektor2d(zasieg, 0));
                break;

            case PRAWO:
                zmienPolozenie(new Wektor2d(0, zasieg));
                break;

            case LEWO:
                zmienPolozenie(new Wektor2d(0, -1 * zasieg));
                break;


        }


    }


    @Override
    public String toString() {
        return "CZLOWIEK";
    }

    @Override
    public Color rysowanie() {
        return new Color(255,253,150);
    }

    @Override
    protected Organizm kopia() {
        return new Czlowiek(polozenie);
    }

}
