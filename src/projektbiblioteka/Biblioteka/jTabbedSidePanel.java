/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektbiblioteka.Biblioteka;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

/**
 *
 * @author student
 */
public class jTabbedSidePanel extends JTabbedPane
{
    private JPanel jPanelEgzemplarz, jPanelKsiazka, jPanelGatunek, jPanelAutor, jPanelWydawnictwo;
    private JList jListEgzemplarz, jListKsiazka, jListGatunek, jListAutor, jListWydawnictwo;
    
    Vector egzemplarze, ksiazki, gatunki, autorzy, wydawnictwa;
    public jTabbedSidePanel()
    {
        CreateTabs();
        FillTabs();
        RoboczyConnect();
    }
    
    private void CreateTabs()
    {
        jPanelEgzemplarz = new JPanel(new GridBagLayout());
        jPanelKsiazka = new JPanel(new GridBagLayout());
        jPanelGatunek = new JPanel(new GridBagLayout());
        jPanelAutor = new JPanel(new GridBagLayout());
        jPanelWydawnictwo = new JPanel(new GridBagLayout());
        
        this.addTab("Egzemplarz", jPanelEgzemplarz);
        this.addTab("Ksiazka", jPanelKsiazka);
        this.addTab("Gatunek", jPanelGatunek);
        this.addTab("Autor", jPanelAutor);
        this.addTab("Wydawnictwo", jPanelWydawnictwo);
    }
    private void FillTabs()
    {
        CreateTabE();
        CreateTabK();
        CreateTabG();
        CreateTabA();
        CreateTabW();
    }
    private void CreateTabE()
    {
        
    }
    private void CreateTabK()
    {
        GridBagConstraints c = new GridBagConstraints();
        ksiazki = new Vector();
        //Dane tymczasowe
        ksiazki.add("Tytuł 1"); ksiazki.add("Tytuł 2"); ksiazki.add("Tytuł 3");
        jListKsiazka = new JList(ksiazki);
        
        JPanel PanelUp = new JPanel(new GridLayout(1,2)), PanelDown = new JPanel(new GridLayout(1,2)), PanelL = new JPanel(new GridLayout(1,1)), PanelR = new JPanel(new GridLayout(13,1));
        
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0; c.gridy = 1; c.weighty = 0.1;
        jPanelKsiazka.add(PanelDown,c);
        
        c.weightx = 1; c.gridx = 0; c.gridy = 0; c.weighty = 1;
        jPanelKsiazka.add(PanelUp,c);
        ArrayList<JPanel> p = new ArrayList<JPanel>();
        for (int i = 0; i < 13; i++)
        {
            p.add(new JPanel(new GridLayout(1,1)));
            PanelR.add((JPanel)p.get(i));
        }
        PanelUp.add(PanelL); PanelUp.add(PanelR);
        PanelDown.add(new JButton("Pobierz zmiany")); PanelDown.add(new JButton("Zapisz zmiany"));
        PanelL.add(jListKsiazka);
        JLabel jLabelTytul = new JLabel("Tytuł:"), jLabelISBN = new JLabel("ISBN:"), jLabelGatunek = new JLabel("Gatunek:"), jLabelAutor = new JLabel("Autor:"), jLabelWydawnictwo = new JLabel("Wydawnictwo:");
        JTextField JTFTytul = new JTextField(), JTFISBN = new JTextField(), JTFGatunek = new JTextField(), JTFAutor = new JTextField(), JTFWydawnictwo = new JTextField();
        JButton JButtonDodaj = new JButton("Dodaj"), JButtonZmien = new JButton("Zmień"), JButtonUsun = new JButton("Usuń");
        p.get(0).add(jLabelTytul);
        p.get(1).add(JTFTytul);
        p.get(2).add(jLabelISBN);
        p.get(3).add(JTFISBN);
        p.get(4).add(jLabelAutor);
        p.get(5).add(JTFAutor);
        p.get(6).add(jLabelWydawnictwo);
        p.get(7).add(JTFWydawnictwo);
        p.get(8).add(jLabelGatunek);
        p.get(9).add(JTFGatunek);
        p.get(10).add(JButtonZmien);
        p.get(11).add(JButtonDodaj);
        p.get(12).add(JButtonUsun);
    }
    private void CreateTabG()
    {
        GridBagConstraints c = new GridBagConstraints();
        gatunki = new Vector();
        //Dane tymczasowe
        gatunki.add("Gatunek 1"); gatunki.add("Gatunek 2"); gatunki.add("Gatunek 3");
        jListGatunek = new JList(gatunki);
        
        JPanel PanelUp = new JPanel(new GridLayout(1,2)), PanelDown = new JPanel(new GridLayout(1,2)), PanelL = new JPanel(new GridLayout(1,1)), PanelR = new JPanel(new GridLayout(13,1));
        
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0; c.gridy = 1; c.weighty = 0.1;
        jPanelGatunek.add(PanelDown,c);
        
        c.weightx = 1; c.gridx = 0; c.gridy = 0; c.weighty = 1;
        jPanelGatunek.add(PanelUp,c);
        ArrayList<JPanel> p = new ArrayList<JPanel>();
        for (int i = 0; i < 13; i++)
        {
            p.add(new JPanel(new GridLayout(1,1)));
            PanelR.add((JPanel)p.get(i));
        }
        PanelUp.add(PanelL); PanelUp.add(PanelR);
        PanelDown.add(new JButton("Pobierz zmiany")); PanelDown.add(new JButton("Zapisz zmiany"));
        PanelL.add(jListGatunek);
        JLabel jLabelNazwa = new JLabel("Nazwa:");
        JTextField JTFNazwa = new JTextField();
        JButton JButtonDodaj = new JButton("Dodaj"), JButtonZmien = new JButton("Zmień"), JButtonUsun = new JButton("Usuń");
        p.get(0).add(jLabelNazwa);
        p.get(1).add(JTFNazwa);
        //p.get(2).add();
        //p.get(3).add();
        //p.get(4).add();
        //p.get(5).add();
        //p.get(6).add();
        //p.get(7).add();
        //p.get(8).add();
        //p.get(9).add();
        p.get(10).add(JButtonZmien);
        p.get(11).add(JButtonDodaj);
        p.get(12).add(JButtonUsun);
    }
    private void CreateTabA()
    {
        GridBagConstraints c = new GridBagConstraints();
        autorzy = new Vector();
        //Dane tymczasowe
        autorzy.add("Autor 1"); autorzy.add("Autor 2"); autorzy.add("Autor 3");
        jListAutor = new JList(autorzy);
        
        JPanel PanelUp = new JPanel(new GridLayout(1,2)), PanelDown = new JPanel(new GridLayout(1,2)), PanelL = new JPanel(new GridLayout(1,1)), PanelR = new JPanel(new GridLayout(13,1));
        
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0; c.gridy = 1; c.weighty = 0.1;
        jPanelAutor.add(PanelDown,c);
        
        c.weightx = 1; c.gridx = 0; c.gridy = 0; c.weighty = 1;
        jPanelAutor.add(PanelUp,c);
        ArrayList<JPanel> p = new ArrayList<JPanel>();
        for (int i = 0; i < 13; i++)
        {
            p.add(new JPanel(new GridLayout(1,1)));
            PanelR.add((JPanel)p.get(i));
        }
        PanelUp.add(PanelL); PanelUp.add(PanelR);
        PanelDown.add(new JButton("Pobierz zmiany")); PanelDown.add(new JButton("Zapisz zmiany"));
        PanelL.add(jListAutor);
        JLabel jLabelImie = new JLabel("Imię:"), jLabelNazwisko = new JLabel("Nazwisko:");
        JTextField JTFImie = new JTextField(), JTFNazwisko = new JTextField();
        JButton JButtonDodaj = new JButton("Dodaj"), JButtonZmien = new JButton("Zmień"), JButtonUsun = new JButton("Usuń");
        p.get(0).add(jLabelNazwisko);
        p.get(1).add(JTFNazwisko);
        p.get(2).add(jLabelImie);
        p.get(3).add(JTFImie);
        //p.get(4).add();
        //p.get(5).add();
        //p.get(6).add();
        //p.get(7).add();
        //p.get(8).add();
        //p.get(9).add();
        p.get(10).add(JButtonZmien);
        p.get(11).add(JButtonDodaj);
        p.get(12).add(JButtonUsun);
    }
    private void CreateTabW()
    {
        GridBagConstraints c = new GridBagConstraints();
        wydawnictwa = new Vector();
        //Dane tymczasowe
        wydawnictwa.add("Wydawnictwo 1"); wydawnictwa.add("Wydawnictwo 2"); wydawnictwa.add("Wydawnictwo 3");
        jListWydawnictwo = new JList(wydawnictwa);
        
        JPanel PanelUp = new JPanel(new GridLayout(1,2)), PanelDown = new JPanel(new GridLayout(1,2)), PanelL = new JPanel(new GridLayout(1,1)), PanelR = new JPanel(new GridLayout(13,1));
        
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0; c.gridy = 1; c.weighty = 0.1;
        jPanelWydawnictwo.add(PanelDown,c);
        
        c.weightx = 1; c.gridx = 0; c.gridy = 0; c.weighty = 1;
        jPanelWydawnictwo.add(PanelUp,c);
        ArrayList<JPanel> p = new ArrayList<JPanel>();
        for (int i = 0; i < 13; i++)
        {
            p.add(new JPanel(new GridLayout(1,1)));
            PanelR.add((JPanel)p.get(i));
        }
        PanelUp.add(PanelL); PanelUp.add(PanelR);
        PanelDown.add(new JButton("Pobierz zmiany")); PanelDown.add(new JButton("Zapisz zmiany"));
        PanelL.add(jListWydawnictwo);
        JLabel jLabelNazwa = new JLabel("Nazwa:"), jLabelAdres = new JLabel("Adres:");
        JTextField JTFNazwa = new JTextField(), JTFAdres = new JTextField();
        JButton JButtonDodaj = new JButton("Dodaj"), JButtonZmien = new JButton("Zmień"), JButtonUsun = new JButton("Usuń");
        p.get(0).add(jLabelNazwa);
        p.get(1).add(jLabelAdres);
        p.get(2).add(JTFNazwa);
        p.get(3).add(JTFAdres);
        //p.get(4).add();
        //p.get(5).add();
        //p.get(6).add();
        //p.get(7).add();
        //p.get(8).add();
        //p.get(9).add();
        p.get(10).add(JButtonZmien);
        p.get(11).add(JButtonDodaj);
        p.get(12).add(JButtonUsun);
    }
    
    
    private void RoboczyConnect()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@oracle.wspa.edu.pl:1521:wspa3","username","password");
            java.sql.Statement stmt = con.createStatement();
            String query = "SELECT nazwa FROM gatunki";
            ResultSet rs = stmt.executeQuery(query);
            jListGatunek.removeAll();
            while (rs.next())
            {
                gatunki.add(rs.getString("nazwa"));
            }
        }
        catch(Exception e)
        {
            gatunki.add("Przewrocilem sie!");
        }
    }
}
