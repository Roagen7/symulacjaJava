package Roagen7.com.github.pomocnicze;

import Roagen7.com.github.symulacja.Swiat;
import Roagen7.com.github.symulacja.organizmy.Organizm;
import Roagen7.com.github.symulacja.organizmy.zwierzeta.Czlowiek;

import javax.swing.*;
import java.io.*;

public class MenedzerPlikow {


    public void zapisz(Swiat swiat, File plik){

        try {

            FileWriter out = new FileWriter(plik);


            out.write(swiat.getNrTury() + " " + swiat.getWysokosc() + " " + swiat.getSzerokosc() + "\n");

            for(Organizm org : swiat.getOrganizmy()){

                out.write(org.toString() + " " +
                        org.getWiek() + " " +
                        org.getPolozenie().getY() + " " +
                        org.getPolozenie().getX());

                if(org instanceof Czlowiek){

                    out.write(" " + ((Czlowiek) org).getTurySpecjalne());

                }

                out.write("\n");

            }

            out.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,"błąd zapisu","błąd",JOptionPane.ERROR_MESSAGE);

        }


    }

    public Swiat wczytaj(File plik){

        return new Swiat(1,1);

    }

}
