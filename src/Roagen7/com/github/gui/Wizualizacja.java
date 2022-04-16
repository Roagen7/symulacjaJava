package Roagen7.com.github.gui;

import Roagen7.com.github.pomocnicze.Dziennik;
import Roagen7.com.github.pomocnicze.Wektor2d;
import Roagen7.com.github.symulacja.Swiat;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.zwierzeta.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Wizualizacja extends JPanel implements MouseListener, KeyListener {




    public Wizualizacja(int wysokoscOkienka, Swiat swiat) {

        this.wysokosc = swiat.getWysokosc();
        this.szerokosc = swiat.getSzerokosc();
        this.wysokoscOkienka = wysokoscOkienka;
        this.swiat = swiat;

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

    }

    public Dziennik getDziennik(){

        return swiat.getDziennik();

    }


    public void nastepnaTura(){

            swiat.wykonajTure();
            paint(this.getGraphics());
            System.out.print(swiat.getDziennik().wypisz());

            requestFocus();
    }

    public boolean maCzlowieka(){

        for(Organizm org : swiat.getOrganizmy()){

            if(org instanceof Czlowiek) return true;

        }

        return false;

    }


    @Override
    public void paint(Graphics g){

        g.setColor(KOLOR_TLA);

        int rozmiarZwierzecia = wysokoscOkienka/wysokosc;
        g.fillRect(0,0,szerokosc * rozmiarZwierzecia,wysokosc * rozmiarZwierzecia);


        for(int y = 0; y < wysokosc; y++){

            for(int x = 0; x < szerokosc; x++){

                Organizm org = swiat.getOrganizmNaPozycji(new Wektor2d(y,x));

                if(org != null){

                    g.setColor(org.rysowanie());

                    g.fillRect(x* rozmiarZwierzecia,y* rozmiarZwierzecia, rozmiarZwierzecia, rozmiarZwierzecia);

                }

            }

        }

       if(maCzlowieka()){

           czlowiekInfo(g);

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

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {


        System.out.println("ruch");

        switch(keyEvent.getKeyCode()){

            case KeyEvent.VK_UP:
                swiat.setRuch(Swiat.Ruch.GORA);
                break;

            case KeyEvent.VK_DOWN:
                swiat.setRuch(Swiat.Ruch.DOL);
                break;

            case KeyEvent.VK_LEFT:
                swiat.setRuch(Swiat.Ruch.LEWO);
                break;

            case KeyEvent.VK_RIGHT:
                swiat.setRuch(Swiat.Ruch.PRAWO);
                break;

            case KeyEvent.VK_Z:
                swiat.setRuch(Swiat.Ruch.SPECJALNY);
                break;

        }

        paint(getGraphics());

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }



    private static final Color KOLOR_TLA = new Color(0,0,0);
    private static final Color KOLOR_INFO = new Color(255,200,200);

    private Swiat swiat;
    private final int wysokosc;
    private final int szerokosc;

    private final int wysokoscOkienka;


    private void czlowiekInfo(Graphics g){

        g.setColor(KOLOR_INFO);
        String komunikat = "Ruch czlowieka: ";

        switch(swiat.getRuch()){

            case GORA:
                komunikat+="do gory";
                break;
            case DOL:
                komunikat+= "na dol";
                break;
            case STOJ:
                komunikat+="bedzie stal";
                break;
            case LEWO:
                komunikat+="w lewo";
                break;
            case PRAWO:
                komunikat+="w prawo";
                break;
            case SPECJALNY:
                komunikat+="uruchomi umiejetnosc specjalna";
                break;

        }


        g.drawString(komunikat,0,10);

    }

}
