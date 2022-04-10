package Roagen7.com.github.symulacja;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;

import java.util.Vector;

public class Swiat {




    public enum Ruch {

        GORA,
        DOL,
        LEWO,
        PRAWO,
        SPECJALNY,
        STOJ

    }

    public Swiat(int wysokosc, int szerokosc){

        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        organizmy = new Vector<>();

    }

    public void addOrganizm(Organizm organizm){

        organizmy.add(organizm);

    }

    public Organizm getOrganizmNaPozycji(Wektor2d p){

        for(Organizm org : organizmy){


            if(org.getPolozenie().equals(p) && org.isZywy()){

                return org;

            }

        }

        return null;

    }


    private int wysokosc;
    private int szerokosc;

    private int nrTury;
    private Ruch ruch = Ruch.STOJ;

    Vector<Organizm> organizmy;


    private void ruchOrganizmow(){



    }


    private void pozbadzSieZwlok(){



    }

}

