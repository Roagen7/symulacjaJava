package Roagen7.com.github.symulacja;

import Roagen7.com.github.pomocnicze.Dziennik;
import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Zwierze;

import java.util.Collections;
import java.util.Vector;

public class Swiat {


    public int getWysokosc() {

        return wysokosc;

    }

    public int getSzerokosc() {

        return szerokosc;

    }

    public Organizm getKolidujacy(Organizm org) {

        for(Organizm organizm : organizmy){

            if(org.getPolozenie().equals(organizm.getPolozenie())
            && org != organizm
            && org.isZywy()){

                return organizm;

            }

        }

        return null;

    }

    public Wektor2d getWolnePoleObok(Wektor2d p) {

        for(int dy = -1; dy <= 1; dy++){

            for(int dx = -1; dx <= 1; dx++){

                Wektor2d sprawdzanyPunkt = new Wektor2d(p.getY() + dy, p.getX() + dx);

                if(!sprawdzanyPunkt.equals(p)
                && getOrganizmNaPozycji(sprawdzanyPunkt) == null
                && !sprawdzanyPunkt.pozaGranicami(wysokosc,szerokosc)){

                    return sprawdzanyPunkt;

                }


            }


        }
        return p;

    }

    public Dziennik getDziennik() {

        return dziennik;

    }

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
        dziennik = new Dziennik();

    }

    public void wykonajTure(){

        oglosNowaTure();
        nrTury++;
        ruchOrganizmow();
        pozbadzSieZwlok();

    }

    public void addOrganizm(Organizm organizm){

        organizm.setWiek(organizm.getWiek()+1);
        organizm.setSwiat(this);

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


    private final int wysokosc;
    private final int szerokosc;

    private int nrTury;
    private Ruch ruch = Ruch.STOJ;

    private Dziennik dziennik;

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

        for(int i = 0; i < organizmy.size(); i++){

            if(!organizmy.get(i).isZywy()){

                organizmy.remove(i);
                pozbadzSieZwlok();
                break;

            }

        }

    }

    private void oglosNowaTure(){

        dziennik.czysc();

        for(Organizm organizm : organizmy){

            organizm.nowaTura();

        }

    }

}

