package Roagen7.com.github.gui;

import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.Swiat;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.Zwierze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import static java.lang.Math.random;

public class Wizualizacja extends JPanel implements MouseListener {

    public static final int ROZMIAR_ZWIERZECIA = 30;

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

    }


    @Override
    public void paint(Graphics g){


        for(int y = 0; y < wysokosc/ROZMIAR_ZWIERZECIA; y++){

            for(int x = 0; x < szerokosc/ROZMIAR_ZWIERZECIA; x++){

                Organizm org = swiat.getOrganizmNaPozycji(new Wektor2d(y,x));



                if(org != null){
                    System.out.println(y + " " + x);
                    g.setColor(new Color(255,0,0));

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
