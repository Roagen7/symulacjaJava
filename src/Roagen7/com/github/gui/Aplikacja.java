package Roagen7.com.github.gui;

import Roagen7.com.github.pomocnicze.MenedzerPlikow;
import Roagen7.com.github.symulacja.Swiat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Aplikacja extends JFrame {


    public static final String TYTUL = "Symulacja";
    public static final int DOMYSLNA_WYSOKOSC = 600;
    public static final int DOMYSLNA_SZEROKOSC = 600;


    public Aplikacja(int wysokosc, int szerokosc){

        setSize(szerokosc,wysokosc);
        setMinimumSize(new Dimension(szerokosc,wysokosc));

        revalidate();

        setTitle(TYTUL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wizualizacja = new Wizualizacja(DOMYSLNA_WYSOKOSC * 8/10, Swiat.Bazowy());
        menedzerPlikow = new MenedzerPlikow();

        inicjujMenuGorne();
        inicjujPanelGlowny();

    }


    public void start(){

        setVisible(true);


    }


    private final Wizualizacja wizualizacja;
    private final MenedzerPlikow menedzerPlikow;

    private JButton turaButton;
    private JButton dziennikButton;
    private JMenuItem menuItemBazowy;
    private JMenuItem menuItemWczytaj;
    private JMenuItem menuItemZapisz;


    private void inicjujMenuGorne(){

        JMenuBar menuBar = new JMenuBar();

        JMenu menuNowy = new JMenu("Nowy");
        JMenu menuPlik = new JMenu("Plik");

        inicjujGuzikiMenuGornego();

        menuNowy.add(menuItemBazowy);
        menuPlik.add(menuItemWczytaj);
        menuPlik.add(menuItemZapisz);

        menuBar.add(menuNowy);
        menuBar.add(menuPlik);

        setJMenuBar(menuBar);

    }

    private void inicjujGuzikiMenuGornego(){

        menuItemBazowy = new JMenuItem("bazowy");
        menuItemWczytaj = new JMenuItem("wczytaj");
        menuItemZapisz = new JMenuItem("zapisz");

        menuItemBazowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                wizualizacja.setSwiat(Swiat.Bazowy());

            }

        });

        menuItemWczytaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("wybierz plik do wczytania");

                int rv = fc.showOpenDialog(null);

                if(rv == JFileChooser.APPROVE_OPTION){

                    File plik = fc.getSelectedFile();
                    Swiat sw = menedzerPlikow.wczytaj(plik);

                    if(sw != null){

                        wizualizacja.setSwiat(sw);

                    }

                }


            }

        });

        menuItemZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("wybierz plik do zapisu");

                int rv = fc.showOpenDialog(null);

                if(rv == JFileChooser.APPROVE_OPTION){

                    File plik = fc.getSelectedFile();
                    menedzerPlikow.zapisz(wizualizacja.getSwiat(), plik);

                }

            }

        });


    }


    private void inicjujPanelGlowny(){


       inicjujGuziki();

        JPanel panelGuziki = new JPanel();



        GridLayout layout = new GridLayout(0,2);
        panelGuziki.setLayout(layout);

        panelGuziki.add(turaButton);
        panelGuziki.add(dziennikButton);


        JSplitPane splitPane = new JSplitPane();

        splitPane.setEnabled(false);
        splitPane.setDividerLocation( DOMYSLNA_WYSOKOSC * 8 / 10);
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
