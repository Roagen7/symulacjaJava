package Roagen7.com.github.pomocnicze;

import Roagen7.com.github.symulacja.Swiat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MenedzerPlikow {


    public void zapisz(Swiat swiat, File plik){

        try {

            FileOutputStream out = new FileOutputStream(plik);



            out.close();

        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    public Swiat wczytaj(File plik){



        return new Swiat(1,1);
    }

}
