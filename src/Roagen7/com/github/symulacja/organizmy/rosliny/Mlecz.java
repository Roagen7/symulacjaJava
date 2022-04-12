package Roagen7.com.github.symulacja.organizmy.rosliny;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Roslina;

import java.awt.*;

public class Mlecz extends Roslina {

    public static final int SILA = 0;
    public static final int PROBY = 3;

    public Mlecz(Wektor2d polozenie) {
        super(polozenie, SILA);
    }

    @Override
    public void akcja(){

        for(int i = 0; i < PROBY; i++){

            rozsiej();

        }

    }

    @Override
    public String toString() {
        return "MLECZ";
    }

    @Override
    public Color rysowanie() {
        return Color.YELLOW;
    }

    @Override
    protected Mlecz kopia() {
        return new Mlecz(polozenie);
    }
}
