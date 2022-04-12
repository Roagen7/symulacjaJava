package Roagen7.com.github.symulacja.organizmy.zwierzeta;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Zwierze;

import java.awt.*;

import static java.lang.Math.random;

public class Antylopa extends Zwierze {

    public static final int SILA = 4;
    public static final int INICJATYWA = 4;
    public static final int ZASIEG = 2;
    public static final double P_UCIECZKI = 0.5;


    public Antylopa(Wektor2d polozenie) {
        super(polozenie, SILA, INICJATYWA);
    }

    @Override
    public void akcja(){

        losowyRuch(ZASIEG);

    }

    @Override
    public String toString() {
        return "ANTYLOPA";
    }

    @Override
    public Color rysowanie() {

        return new Color(150,75,0);

    }

    @Override
    protected Antylopa kopia() {
        return new Antylopa(polozenie);
    }

    @Override
    public boolean czyUciekl(){

        return random() < P_UCIECZKI;

    }

}
