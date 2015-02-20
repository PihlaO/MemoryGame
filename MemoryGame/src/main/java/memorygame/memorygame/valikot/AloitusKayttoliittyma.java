/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.valikot;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import memorygame.memorygame.Pelitilasto;

/**
 *
 * @author okpiok
 */
public class AloitusKayttoliittyma implements Runnable { //miten voidaan sulkea

    private JFrame frame;
    Pelitilasto helppotaso;
    Pelitilasto keskitaso;
    Pelitilasto vaikeataso;

    public AloitusKayttoliittyma(Pelitilasto helppotaso, Pelitilasto keskitaso, Pelitilasto vaikeataso) {
        this.helppotaso = helppotaso;
        this.keskitaso = keskitaso;
        this.vaikeataso = vaikeataso;
    }

    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(300, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(8, 1);
        container.setLayout(layout);

        JLabel teksti = new JLabel("Muistipeli");
        JLabel nimiTeksti = new JLabel("Nimi: ");
        JTextField nimiKentta = new JTextField();

        JLabel valitseTasoTeksti = new JLabel("Aloita peli valitsemalla vaikeustaso:");
        JButton helppo = new JButton("Helppo");
        JButton keskitaso = new JButton("Keskitaso");
        JButton vaikea = new JButton("Vaikea");
        lisaaKuuntelijat(nimiKentta, helppo, keskitaso, vaikea, this);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(helppo);
        buttonGroup.add(keskitaso);
        buttonGroup.add(vaikea);

        container.add(teksti);
        container.add(nimiTeksti);
        container.add(nimiKentta);
        container.add(valitseTasoTeksti);
        container.add(helppo);
        container.add(keskitaso);
        container.add(vaikea);

    }

    private void lisaaKuuntelijat(JTextField nimiKentta, JButton helppo, JButton keskitaso, JButton vaikea, AloitusKayttoliittyma kali) {
        helppo.addActionListener(new PelinAloituksenKuuntelija(nimiKentta, helppo, keskitaso, vaikea, kali));
        keskitaso.addActionListener(new PelinAloituksenKuuntelija(nimiKentta, helppo, keskitaso, vaikea, kali));
        vaikea.addActionListener(new PelinAloituksenKuuntelija(nimiKentta, helppo, keskitaso, vaikea, kali));
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public Pelitilasto getHelponTasonTilasto(){
        return this.helppotaso;
    }
    public Pelitilasto getKeskiTasonTilasto(){
        return this.keskitaso;
    }
    public Pelitilasto getVaikeanTasonTilasto(){
        return this.vaikeataso;
    }

    public AloitusKayttoliittyma getAloitusKali() {
        return this;
    }
}
