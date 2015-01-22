/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektbiblioteka;

/**
 *
 *  * @author Mela Paulina, Migas Michal, Zimnicki Piotr
 */
public class Pracownik extends Osoba implements IOsoba 
{
    private String Adres;
    private int ID;
    private String Telefon;
    private String Stanowisko;
    private static int LastId = 0;
    
    public Pracownik(String imie, String nazwisko, String adres, String telefon, String stanowisko)
    {
        this.Imie = imie; this.Nazwisko = nazwisko; this.Adres = adres; this.Telefon = telefon; this.Stanowisko = stanowisko;
        Pracownik.LastId++;
        this.ID = Pracownik.LastId;
    };
    public Pracownik(String imie, String nazwisko){this(imie, nazwisko, "", "", "");};
    public Pracownik(String nazwisko){this("",nazwisko);};
    public Pracownik(){this("","","","","");};
    
    public int GetID(){return this.ID;};
    public String GetAdres(){return this.Adres;};
    public String GetTelefon(){return this.Telefon;};
    public String GetStanowisko(){return this.Stanowisko;};
    
    public boolean ZmienDane(String NoweImie, String NoweNazwisko, String adres, String telefon, String stanowisko){return false;};
    
    @Override
    public boolean ZmienDane(String NoweImie, String NoweNazwisko){return false;};
    @Override
    public boolean ZmienImie(String NoweImie){return false;};
    @Override
    public boolean ZmienNazwisko(String NoweNazwisko){return false;};
}
