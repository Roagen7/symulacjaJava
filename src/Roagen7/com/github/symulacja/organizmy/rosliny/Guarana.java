package Roagen7.com.github.symulacja.organizmy.rosliny;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Roslina;

import java.awt.*;

public class Guarana extends Roslina {

    public static final int SILA = 0;
    public static final int ZWIEKSZENIE_SILY = 3;

    public Guarana(Wektor2d polozenie) {
        super(polozenie, SILA);
    }

    @Override
    public void dodajModyfikator(Organizm organizm){

        organizm.setSila(organizm.getSila() + ZWIEKSZENIE_SILY);

    }

    @Override
    public String toString() {
        return "GUARANA";
    }

    @Override
    public Color rysowanie() {
        return Color.magenta;
    }

    @Override
    protected Guarana kopia() {
        return new Guarana(polozenie);
    }
}
