package Roagen7.com.github.symulacja.organizmy;

import Roagen7.com.github.pomocnicze.Wektor2d;

import static java.lang.Math.random;

abstract public class Zwierze extends Organizm{


    public Zwierze(Wektor2d polozenie, int sila, int inicjatywa){

        super(polozenie,sila,inicjatywa);

    }


    @Override
    public void akcja() {

        losowyRuch(1);
    }

    @Override
    public void kolizja() {

        Organizm drugi = swiat.getKolidujacy(this);
        if(drugi == null) return;

        if(drugi.toString().equals(toString())){

            rozmnozSie((Zwierze) drugi);

        } else {

            walcz(drugi);

        }

    }



    @Override
    public void nowaTura() {

        rozmnozylSie = false;

    }




    protected void losowyRuch(int zasieg){

        if(czyMaDobryWech() && wszyscySasiedziSilniejsi()){

            return;

        }

        int[] koordynaty = {-1 * zasieg, 0, zasieg};

        Wektor2d przemieszczenie = new Wektor2d(0,0);
        Wektor2d wczesniejsze = new Wektor2d(polozenie.getY(),polozenie.getX());

        do {

            int randX = koordynaty[(int) (random() * 3)];
            int randY = koordynaty[(int) (random() * 3)];

            przemieszczenie = new Wektor2d(randY,randX);

            zmienPolozenie(przemieszczenie);

        } while(wczesniejsze.equals(polozenie) ||
                (czyMaDobryWech() &&
                swiat.getKolidujacy(this) != null &&
                swiat.getKolidujacy(this).getSila() > getSila()));

    }

    protected void zmienPolozenie(Wektor2d przemieszczenie){

        if(!polozenie.dodaj(przemieszczenie).pozaGranicami(swiat.getWysokosc(),swiat.getSzerokosc())){

            wczesniejszePolozenie = new Wektor2d(polozenie.getY(),polozenie.getX());
            polozenie.dodajEq(przemieszczenie);

        }


    }

    private boolean rozmnozylSie = false;
    private Wektor2d wczesniejszePolozenie;

    private void walcz(Organizm drugi){

        if(ucieczka() || drugi.ucieczka()) return;


        if(getSila() < drugi.getSila()){

            if(czyOdbilAtak(drugi)){

                cofnijSie();
                return;

            }

            swiat.getDziennik().wpisz(drugi.toString() + " zjada " + toString());

            zabij();
            dodajModyfikator(drugi);

        } else {

            if(drugi.czyOdbilAtak(this)){

                cofnijSie();
                return;

            }

            swiat.getDziennik().wpisz(toString() + " zjada " + drugi.toString());

            drugi.zabij();
            drugi.dodajModyfikator(this);

        }


    }

    private void rozmnozSie(Zwierze drugi){

        if(drugi.getWiek() == 0){

            return;

        }



        Organizm org = kopia();

        cofnijSie();

        Wektor2d miejsceNarodzin = swiat.getWolnePoleObok(drugi.getPolozenie());
        if(miejsceNarodzin.equals(drugi.getPolozenie()) || rozmnozylSie || drugi.rozmnozylSie){

                return;

        }

        org.setPolozenie(miejsceNarodzin);
        org.setWiek(-1);

        swiat.addOrganizm(org);

        rozmnozylSie = true;
        drugi.rozmnozylSie = true;





    }

    private void cofnijSie(){

        setPolozenie(wczesniejszePolozenie);


    }

    private boolean wszyscySasiedziSilniejsi(){

        for(int y = -1; y <= 1; y++){

            for(int x = -1; x <= 1; x++){

                Wektor2d pol = new Wektor2d(y,x);

                Organizm org = swiat.getOrganizmNaPozycji(polozenie.dodaj(pol));

                if(org != this && (org == null || org.getSila() <= sila)){

                    return false;

                }

            }

        }

        return true;

    }



}
