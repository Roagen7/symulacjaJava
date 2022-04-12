package Roagen7.com.github.symulacja.organizmy.zwierzeta;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Zwierze;

import java.awt.*;

public class Lis extends Zwierze {

    public static final int SILA = 3;
    public static final int INICJATYWA = 7;


    public Lis(Wektor2d polozenie) {
        super(polozenie, SILA, INICJATYWA);
    }

    @Override
    public String toString() {
        return "LIS";
    }

    @Override
    public Color rysowanie() {
        return Color.ORANGE;
    }

    @Override
    protected Organizm kopia() {
        return new Lis(polozenie);
    }

    @Override
    protected boolean czyMaDobryWech(){

        return true;

    }

}
