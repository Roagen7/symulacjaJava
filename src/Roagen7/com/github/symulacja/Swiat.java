package Roagen7.com.github.symulacja;

import Roagen7.com.github.pomocnicze.Dziennik;
import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.rosliny.*;
import Roagen7.com.github.symulacja.organizmy.zwierzeta.*;

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

                if(typ == Typ.Hex && ((dy == -1 && dx == -1) || (dy == 1 && dx == -1))){

                    continue;

                }


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

    public int getNrTury() {

        return nrTury;

    }

    public void setNrTury(int nrTury) {

        this.nrTury = nrTury;

    }

    public Typ getTyp() {
        return typ;
    }

    public enum Ruch {

        GORA,
        DOL,
        LEWO,
        PRAWO,
        SPECJALNY,
        STOJ

    }

    public enum Typ {

        Kartezjanski,
        Hex

    }


    public Swiat(int wysokosc, int szerokosc){

        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        organizmy = new Vector<>();
        dziennik = new Dziennik();

        typ = Typ.Hex;

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

        Organizm szukany = null;

        for(Organizm org : organizmy){

            if(org.getPolozenie().equals(p) && org.isZywy()){

                if(szukany == null || szukany.getSila() < org.getSila()){

                    szukany = org;

                }

            }

        }

        return szukany;

    }

    public void setRuch(Ruch ruch){

        this.ruch = ruch;

    }

    public Ruch popRuch(){

        Ruch obecny = ruch;
        ruch = Ruch.STOJ;

        return obecny;

    }

    public Ruch getRuch(){

        return ruch;

    }

    public Vector<Organizm> getOrganizmy() {

        return organizmy;

    }

    public static Swiat Bazowy(){


        Swiat swiat = new Swiat(
        30,
                30);

        swiat.addOrganizm(new Wilk(new Wektor2d(0,3)));
        swiat.addOrganizm(new Wilk(new Wektor2d(0,4)));

        swiat.addOrganizm(new Owca(new Wektor2d(6,6)));
        swiat.addOrganizm(new Owca(new Wektor2d(7,6)));
        swiat.addOrganizm(new Mlecz(new Wektor2d(10,10)));
        swiat.addOrganizm(new Lis(new Wektor2d(10,5)));
        swiat.addOrganizm(new Lis(new Wektor2d(10,6)));
        swiat.addOrganizm(new Lis(new Wektor2d(10,7)));
        swiat.addOrganizm(new Zolw(new Wektor2d(20,20)));
        swiat.addOrganizm(new Trawa(new Wektor2d(20,4)));
        swiat.addOrganizm(new Antylopa(new Wektor2d(30,5)));
        swiat.addOrganizm(new Antylopa(new Wektor2d(30,6)));
        swiat.addOrganizm(new Guarana(new Wektor2d(25,5)));
        swiat.addOrganizm(new Guarana(new Wektor2d(25,6)));

        swiat.addOrganizm(new WilczeJagody(new Wektor2d(0,0)));
        swiat.addOrganizm(new WilczeJagody(new Wektor2d(1,0)));

        swiat.addOrganizm(new BarszczSosnowskiego(new Wektor2d(21,24)));
        swiat.addOrganizm(new Czlowiek(new Wektor2d(25,25)));

        return swiat;
    }


    private final int wysokosc;
    private final int szerokosc;

    private int nrTury;
    private Ruch ruch = Ruch.STOJ;
    private Typ typ = Typ.Kartezjanski;

    private Dziennik dziennik;

    Vector<Organizm> organizmy;


    private void ruchOrganizmow(){

        organizmy.sort((Organizm o1, Organizm o2) -> {

            if(o1.getInicjatywa() == o2.getInicjatywa()){

                return o2.getWiek() - o1.getWiek();

            }
            return o2.getInicjatywa() - o1.getInicjatywa() ;
        });

        for(int i = 0; i < organizmy.size(); i++){

            Organizm organizm = organizmy.get(i);

            if(organizm.isZywy() ){

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

