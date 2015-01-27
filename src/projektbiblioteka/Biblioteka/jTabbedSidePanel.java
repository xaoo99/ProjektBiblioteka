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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

/**
 * @author Mela Paulina, Migas Michal, Zimnicki Piotr
 */
public class jTabbedSidePanel extends JTabbedPane
{
    private Biblioteka Owner;
    
    private JPanel jPanelEgzemplarz, jPanelKsiazka, jPanelGatunek, jPanelAutor, jPanelWydawnictwo;
    private JList jListEgzemplarz, jListKsiazka, jListGatunek, jListAutor, jListWydawnictwo;
    
    private DefaultListModel egzemplarze, ksiazki, gatunki, autorzy, wydawnictwa;
    public jTabbedSidePanel(Biblioteka owner)
    {
        this.Owner = owner;
        CreateTabs();
        FillTabs();
        if(this.Owner.TryConnect)
        {
            try
            {
            PullDataFromDB(this.Owner.Con);
            }
            catch (java.sql.SQLException e)
            {
                JOptionPane.showMessageDialog(new JFrame(), "błąd połączenia!\n" + e.toString(), "Connection error!",
                    JOptionPane.ERROR_MESSAGE);
                this.Owner.TryConnect = false;
            }
        }
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
        GridBagConstraints c = new GridBagConstraints();
        egzemplarze = new DefaultListModel();
        //Dane tymczasowe
        egzemplarze.addElement("Egzemplarz 1"); egzemplarze.addElement("Egzemplarz 2"); egzemplarze.addElement("Egzemplarz 3");
        jListEgzemplarz = new JList(egzemplarze);
        
        JPanel PanelUp = new JPanel(new GridLayout(1,2)), PanelDown = new JPanel(new GridLayout(1,2)), PanelL = new JPanel(new GridLayout(1,1)), PanelR = new JPanel(new GridLayout(13,1));
        
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0; c.gridy = 1; c.weighty = 0.1;
        jPanelEgzemplarz.add(PanelDown,c);
        
        c.weightx = 1; c.gridx = 0; c.gridy = 0; c.weighty = 1;
        jPanelEgzemplarz.add(PanelUp,c);
        ArrayList<JPanel> p = new ArrayList<JPanel>();
        for (int i = 0; i < 13; i++)
        {
            p.add(new JPanel(new GridLayout(1,1)));
            PanelR.add((JPanel)p.get(i));
        }
        PanelUp.add(PanelL); PanelUp.add(PanelR);
        PanelDown.add(new JButton("Pobierz zmiany")); PanelDown.add(new JButton("Zapisz zmiany"));
        PanelL.add(jListEgzemplarz);
        JLabel jLabelTytul = new JLabel("Tytuł:");
        JTextField JTFTytul = new JTextField();
        JButton JButtonDodaj = new JButton("Dodaj"), JButtonZmien = new JButton("Zmień"), JButtonUsun = new JButton("Usuń");
        p.get(0).add(jLabelTytul);
        p.get(1).add(JTFTytul);
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
    private void CreateTabK()
    {
        GridBagConstraints c = new GridBagConstraints();
        ksiazki = new DefaultListModel();
        //Dane tymczasowe
        ksiazki.addElement("Tytuł 1"); ksiazki.addElement("Tytuł 2"); ksiazki.addElement("Tytuł 3");
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
        gatunki = new DefaultListModel();
        //Dane tymczasowe
        gatunki.addElement("Gatunek 1"); gatunki.addElement("Gatunek 2"); gatunki.addElement("Gatunek 3");
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
        autorzy = new DefaultListModel();
        //Dane tymczasowe
        autorzy.addElement("Autor 1"); autorzy.addElement("Autor 2"); autorzy.addElement("Autor 3");
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
        wydawnictwa = new DefaultListModel();
        //Dane tymczasowe
        wydawnictwa.addElement("Wydawnictwo 1"); wydawnictwa.addElement("Wydawnictwo 2"); wydawnictwa.addElement("Wydawnictwo 3");
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
        p.get(1).add(JTFNazwa);
        p.get(2).add(jLabelAdres);
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
    /**
     * Metoda wyciągająca dane dot. całej biblioteki z bazy danych
     * @param con Połączenie z bazą danych
     * @throws java.sql.SQLException 
     */
    public void PullDataFromDB(Connection con) throws java.sql.SQLException
    {
        this.PullDataFromDB(con,"GATUNEK_nie_wywalaj_prosze","id_g, nazwa");
        this.PullDataFromDB(con,"WYDAWNICTWO_nie_wywalaj_prosze","id_w, nazwa, adres");
        this.PullDataFromDB(con,"KSIAZKA_nie_wywalaj_prosze","id_k, tytul, isbn, id_g, id_a, id_w");
        this.PullDataFromDB(con,"AUTOR_nie_wywalaj_prosze","id_a, imie, nazwisko");
        this.PullDataFromDB(con,"EGZEMPLARZ_nie_wywalaj_prosze","id_e, id_k");
    }
    /**
     * Metoda wyciągająca dane z pojedynczej tabeli bazy danych
     * @param con Połączenie z bazą danych
     * @param table Tabela, z której wyciągniemy dane
     * @param kolumny kolumy z tabeli, oddzielone przecinkami
     * @throws java.sql.SQLException 
     */
    public void PullDataFromDB(Connection con, String table, String kolumny) throws java.sql.SQLException, IllegalArgumentException
    {
        DefaultListModel listaDoZmiany;
        JList ListaDoRepainta;
        if (table == "GATUNEK_nie_wywalaj_prosze")
        {
            listaDoZmiany = gatunki;
            ListaDoRepainta = jListGatunek;
        }
        else if (table == "WYDAWNICTWO_nie_wywalaj_prosze")
        {
            listaDoZmiany = wydawnictwa;
            ListaDoRepainta = jListWydawnictwo;
        }
        else if (table == "KSIAZKA_nie_wywalaj_prosze")
        {
            listaDoZmiany = ksiazki;
            ListaDoRepainta = jListKsiazka;
        }
        else if (table == "AUTOR_nie_wywalaj_prosze")
        {
            listaDoZmiany = autorzy;
            ListaDoRepainta = jListAutor;
        }
        else if (table == "EGZEMPLARZ_nie_wywalaj_prosze")
        {
            listaDoZmiany = egzemplarze;
            ListaDoRepainta = jListEgzemplarz;
        }
        else
            throw new java.lang.IllegalArgumentException("Podana tabela nie istnieje!");
        
        java.sql.Statement stmt = con.createStatement();
        String query = "SELECT " + kolumny + " FROM " + table;
        ResultSet rs = stmt.executeQuery(query);
        gatunki.removeAllElements();
        while (rs.next() == true)
        {
            listaDoZmiany.addElement(rs.getString("nazwa"));
            ListaDoRepainta.repaint();
        }
    }
    
    /**
     * Outdated, to be removed
     */
    private void RoboczyConnect()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@oracle.wspa.edu.pl:1521:oracle","wspa3","wspa3");
            java.sql.Statement stmt = con.createStatement();
            String query = "SELECT nazwa FROM GATUNEK_nie_wywalaj_prosze";
            ResultSet rs = stmt.executeQuery(query);
            gatunki.removeAllElements();
            while (rs.next() == true)
            {
                gatunki.addElement(rs.getString("nazwa"));
                jListGatunek.repaint();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Connection error",
                JOptionPane.ERROR_MESSAGE);
            //gatunki.add("Przewrocilem sie!");
        }
        //jListGatunek.setModel();
    }
}
