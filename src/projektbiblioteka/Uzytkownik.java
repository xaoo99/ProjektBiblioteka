/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektbiblioteka;

/**
 *
 * @author Mela Paulina, Migas Michal, Zimnicki Piotr
 */
public class Uzytkownik extends Osoba implements IOsoba 
{
    private String Adres;
    private String Email;
    private Data DataUrodzenia;
    private int ID;
    private static int LastId = 0;
    
    public Uzytkownik(String imie, String nazwisko, String adres, String email, Data DataUrodzenia)
    {
        this.Imie = imie; this.Nazwisko = nazwisko; this.Adres = adres; this.Email = email; this.DataUrodzenia = DataUrodzenia;
        Uzytkownik.LastId++;
        this.ID = Uzytkownik.LastId;
    };
    
    
    
    public String GetAdres(){return this.Adres;};
    public String GetEmail(){return this.Email;};
    public Data GetDataUrodzenia(){return this.DataUrodzenia;};
    public String GetDUString(){return this.DataUrodzenia.toString();};
    public int GetId(){return this.ID;};
    
    public boolean ZmienDane(String NoweImie, String NoweNazwisko, String adres, String email, Data dataUrodzenia){return false;};
    
    @Override
    public boolean ZmienDane(String NoweImie, String NoweNazwisko){return false;};
    @Override
    public boolean ZmienImie(String NoweImie){return false;};
    @Override
    public boolean ZmienNazwisko(String NoweNazwisko){return false;};
}
