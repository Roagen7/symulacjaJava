package Roagen7.com.github.gui;

import Roagen7.com.github.pomocnicze.Dziennik;
import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.Swiat;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Roslina;
import Roagen7.com.github.symulacja.organizmy.Zwierze;
import Roagen7.com.github.symulacja.organizmy.rosliny.*;
import Roagen7.com.github.symulacja.organizmy.zwierzeta.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Wizualizacja extends JPanel implements MouseListener {

    public static final int ROZMIAR_ZWIERZECIA = 20;

    private static final Color KOLOR_TLA = new Color(0,0,0);
    private final int wysokosc;
    private final int szerokosc;


    private Swiat swiat;

    public Wizualizacja(int wysokosc, int szerokosc) {
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;

        swiat = new Swiat(
                Aplikacja.DOMYSLNA_WYSOKOSC / ROZMIAR_ZWIERZECIA,
                Aplikacja.DOMYSLNA_SZEROKOSC/ ROZMIAR_ZWIERZECIA);

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


    }

    public Dziennik getDziennik(){

        return swiat.getDziennik();

    }


    public void nastepnaTura(){

            swiat.wykonajTure();
            paint(this.getGraphics());
            System.out.print(swiat.getDziennik().wypisz());


    }


    @Override
    public void paint(Graphics g){

        g.setColor(KOLOR_TLA);
        g.fillRect(0,0,szerokosc,wysokosc);


        for(int y = 0; y < wysokosc/ROZMIAR_ZWIERZECIA; y++){

            for(int x = 0; x < szerokosc/ROZMIAR_ZWIERZECIA; x++){

                Organizm org = swiat.getOrganizmNaPozycji(new Wektor2d(y,x));

                if(org != null){

                    g.setColor(org.rysowanie());

                    g.fillRect(x*ROZMIAR_ZWIERZECIA,y*ROZMIAR_ZWIERZECIA,ROZMIAR_ZWIERZECIA, ROZMIAR_ZWIERZECIA);

                }

            }

        }


    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        int x = mouseEvent.getX();
        int y = mouseEvent.getY();

        System.out.println(y + " " + x);

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
