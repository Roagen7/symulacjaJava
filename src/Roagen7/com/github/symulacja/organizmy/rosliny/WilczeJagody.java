package Roagen7.com.github.symulacja.organizmy.rosliny;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Roslina;

import java.awt.*;

public class WilczeJagody extends Roslina {
    public static int SILA = 0;


    public WilczeJagody(Wektor2d polozenie) {
        super(polozenie, SILA);
    }

    @Override
    public void dodajModyfikator(Organizm org){

        org.zabij();

    }

    @Override
    public String toString() {
        return "WILCZE_JAGODY";
    }

    @Override
    public Color rysowanie() {
        return new Color(49, 0, 76);
    }

    @Override
    protected WilczeJagody kopia() {
        return new WilczeJagody(polozenie);
    }
}
