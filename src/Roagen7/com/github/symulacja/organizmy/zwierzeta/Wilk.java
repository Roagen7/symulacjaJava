package Roagen7.com.github.symulacja.organizmy.zwierzeta;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Zwierze;

import java.awt.*;

public class Wilk extends Zwierze {

    public static final int SILA = 9;
    public static final int INICJATYWA = 5;



    public Wilk(Wektor2d polozenie) {
        super(polozenie, SILA, INICJATYWA);
    }

    @Override
    public String toString() {
        return "WILK";
    }

    @Override
    public Color rysowanie() {
        return new Color(244,0,0);
    }

    @Override
    public Wilk kopia() {
        return new Wilk(polozenie);
    }
}
