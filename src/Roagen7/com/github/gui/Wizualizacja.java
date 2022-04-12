package Roagen7.com.github.gui;

import Roagen7.com.github.pomocnicze.Dziennik;
import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.Swiat;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Roslina;
import Roagen7.com.github.symulacja.organizmy.Zwierze;
import Roagen7.com.github.symulacja.organizmy.rosliny.Trawa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Wizualizacja extends JPanel implements MouseListener {

    public static final int ROZMIAR_ZWIERZECIA = 10;



    private static final Color KOLOR_TLA = new Color(255,255,255);
    private final int wysokosc;
    private final int szerokosc;


    private Swiat swiat;

    public Wizualizacja(int wysokosc, int szerokosc) {
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;

        swiat = new Swiat(
                Aplikacja.DOMYSLNA_WYSOKOSC / ROZMIAR_ZWIERZECIA,
                Aplikacja.DOMYSLNA_SZEROKOSC/ ROZMIAR_ZWIERZECIA);

        swiat.addOrganizm(new Zwierze(new Wektor2d(0,3),2,2));
        swiat.addOrganizm(new Zwierze(new Wektor2d(0,4),2,2));

        swiat.addOrganizm(new Trawa(new Wektor2d(20,4)));

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
