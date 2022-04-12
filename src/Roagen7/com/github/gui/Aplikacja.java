package Roagen7.com.github.gui;

import Roagen7.com.github.symulacja.Swiat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


    private final Wizualizacja wizualizacja;
    JButton turaButton;
    JButton dziennikButton;

    private void inicjujMenuGorne(){

        JMenuBar menuBar = new JMenuBar();

        JMenu menuNowy = new JMenu("Nowy");
        JMenu menuPlik = new JMenu("Plik");


        JMenuItem menuItemBazowy = new JMenuItem("bazowy");

        menuNowy.add(menuItemBazowy);

        JMenuItem menuItemWczytaj = new JMenuItem("wczytaj");
        JMenuItem menuItemZapisz = new JMenuItem("zapisz");

        menuPlik.add(menuItemWczytaj);
        menuPlik.add(menuItemZapisz);


        menuBar.add(menuNowy);
        menuBar.add(menuPlik);

        setJMenuBar(menuBar);

    }

    private void inicjujPanelGlowny(){


       inicjujGuziki();

        JPanel panelGuziki = new JPanel();



        panelGuziki.add(turaButton);
        panelGuziki.add(dziennikButton);

        JSplitPane splitPane = new JSplitPane();

        splitPane.setEnabled(false);
        splitPane.setDividerLocation( DOMYSLNA_WYSOKOSC * 9 / 10);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);

        splitPane.addMouseListener(wizualizacja);

        splitPane.setTopComponent(wizualizacja);
        splitPane.setBottomComponent(panelGuziki);

        add(splitPane);

    }

    private void inicjujGuziki(){

        turaButton = new JButton("nastepna tura");
        dziennikButton = new JButton("dziennik");


        turaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                wizualizacja.nastepnaTura();

            }

        });

        dziennikButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showConfirmDialog(null,wizualizacja.getDziennik().wypisz(),"Dziennik", JOptionPane.DEFAULT_OPTION);
            }

        });



    }


}
