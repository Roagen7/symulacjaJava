package Roagen7.com.github.symulacja.organizmy.rosliny;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Roslina;

import java.awt.*;

public class Trawa extends Roslina {

    public static final int SILA = 0;

    public Trawa(Wektor2d polozenie) {
        super(polozenie, SILA);
    }

    @Override
    public String toString(){

        return "TRAWA";

    }

    @Override
    public Color rysowanie() {

        return new Color(72,111,56);

    }

    @Override
    public Organizm kopia() {
        return new Trawa(polozenie);
    }


}
