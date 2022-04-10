package Roagen7.com.github.gui;

import Roagen7.com.github.symulacja.Swiat;

import javax.swing.*;
import java.awt.*;

public class Aplikacja extends JFrame {


    public static final String TYTUL = "Symulacja";
    public static final int DOMYSLNA_WYSOKOSC = 800;
    public static final int DOMYSLNA_SZEROKOSC = 800;


    public Aplikacja(int wysokosc, int szerokosc){

        setSize(szerokosc,wysokosc);
        setTitle(TYTUL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        wizualizacja = new Wizualizacja(DOMYSLNA_WYSOKOSC * 9/10, DOMYSLNA_SZEROKOSC);


        inicjujMenuGorne();
        inicjujPanelGlowny();



    }


    public void start(){

        setVisible(true);


    }



    private JMenuBar menuBar;

    private JMenuItem menuItemBazowy;
    private JMenuItem menuItemWczytaj;
    private JMenuItem menuItemZapisz;

    private JPanel panelGlowny;
    private JPanel panelGuziki;

    private Wizualizacja wizualizacja;


    private void inicjujMenuGorne(){

        menuBar = new JMenuBar();

        JMenu menuNowy = new JMenu("Nowy");
        JMenu menuPlik = new JMenu("Plik");



        menuItemBazowy = new JMenuItem("bazowy");

        menuNowy.add(menuItemBazowy);

        menuItemWczytaj = new JMenuItem("wczytaj");
        menuItemZapisz = new JMenuItem("zapisz");

        menuPlik.add(menuItemWczytaj);
        menuPlik.add(menuItemZapisz);


        menuBar.add(menuNowy);
        menuBar.add(menuPlik);

        setJMenuBar(menuBar);

    }

    private void inicjujPanelGlowny(){


        panelGuziki = new JPanel();
        panelGuziki.add(new JButton("nastepna tura"));

        JSplitPane splitPane = new JSplitPane();

        splitPane.setEnabled(false);
        splitPane.setDividerLocation( DOMYSLNA_WYSOKOSC * 9 / 10);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);

        splitPane.addMouseListener(wizualizacja);

        splitPane.setTopComponent(wizualizacja);
        splitPane.setBottomComponent(panelGuziki);

        add(splitPane);

    }


}
