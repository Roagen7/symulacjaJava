package Roagen7.com.github.symulacja.organizmy;

import Roagen7.com.github.pomocnicze.Wektor2d;

import java.awt.*;

import static java.lang.Math.random;

public class Roslina extends Organizm{

    static final int DOMYSLNA_INICJATYWA = 0;
    static final double P_ROZSIANIA = 0.05;


    public Roslina(Wektor2d polozenie, int sila) {
        super(polozenie, sila, DOMYSLNA_INICJATYWA);
    }

    @Override
    public String toString() {
        return "r";
    }

    @Override
    public void akcja() {

        rozsiej();

    }

    @Override
    public void kolizja() {

    }

    @Override
    public Color rysowanie() {
        return Color.GREEN;
    }

    @Override
    public void nowaTura() {

    }

    @Override
    protected Organizm kopia() {
        return new Roslina(polozenie,sila);
    }

    protected void rozsiej(){

        if(random() < P_ROZSIANIA){

            Wektor2d pNowy = swiat.getWolnePoleObok(polozenie);

            if(pNowy == polozenie) return;

            Organizm org = kopia();
            org.setWiek(0);

            org.setPolozenie(pNowy);

            swiat.addOrganizm(org);


        }


    }
}
