package Roagen7.com.github.symulacja.organizmy.rosliny;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Roslina;
import Roagen7.com.github.symulacja.organizmy.Zwierze;

import java.awt.*;

public class BarszczSosnowskiego extends Roslina {

    public static int SILA = 0;


    public BarszczSosnowskiego(Wektor2d polozenie) {
        super(polozenie, SILA);
    }

    @Override
    public void dodajModyfikator(Organizm org){

        org.zabij();

    }

    @Override
    public void akcja(){

        for(int y = -1; y <= 1; y++){

            for(int x = -1; x <= 1; x++){

                Organizm org = swiat.getOrganizmNaPozycji(polozenie.dodaj(new Wektor2d(y,x)));

                if(org instanceof Zwierze){

                    org.zabij();

                }

            }

        }

        super.akcja();

    }

    @Override
    public String toString() {
        return "BARSZCZ_SOSNOWSKIEGO";
    }

    @Override
    public Color rysowanie() {
        return Color.WHITE;
    }

    @Override
    protected BarszczSosnowskiego kopia() {
        return new BarszczSosnowskiego(polozenie);
    }
}
