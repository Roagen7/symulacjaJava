package Roagen7.com.github.symulacja;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;

import java.util.Collections;
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

    public void wykonajTure(){


        nrTury++;
        ruchOrganizmow();
        pozbadzSieZwlok();

    }

    public void addOrganizm(Organizm organizm){

        organizm.setWiek(1);

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

        organizmy.sort((Organizm o1, Organizm o2) -> {

            if(o1.getInicjatywa() == o2.getInicjatywa()){

                return o1.getWiek() - o2.getWiek();

            }


            return o1.getInicjatywa() - o2.getInicjatywa() ;
        });

        for(int i = 0; i < organizmy.size(); i++){

            Organizm organizm = organizmy.get(i);

            if(organizm.isZywy() && organizm.getWiek() != 0){

                organizm.akcja();
                organizm.kolizja();

            }

            organizm.starzejSie();

        }


    }


    private void pozbadzSieZwlok(){



    }

    private void oglosNowaTure(){



    }

}

