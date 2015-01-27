/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektbiblioteka;

/**
 * Klasa opisująca autora książki
 * @author Mela Paulina, Migas Michal, Zimnicki Piotr
 */
public class Autor extends Osoba implements IOsoba 
{
    public Autor(String imie, String nazwisko){this.Imie = imie; this.Nazwisko = nazwisko;};
    public Autor(String nazwisko){this("",nazwisko);};
    public Autor(){this("","");};
    /**
     * Metoda umożliwiająca zmianę danych autora
     */
    @Override
    public boolean ZmienDane(String NoweImie, String NoweNazwisko){return false;};
    /**
     * Metoda umożliwiająca zmianę imienia autora
     */
    @Override
    public boolean ZmienImie(String NoweImie){return false;};
    /**
     * Metoda umożliwijąca zmianę nazwiska autora
     */
    @Override
    public boolean ZmienNazwisko(String NoweNazwisko){return false;};
   
    @Override
    public String toString()
    {
        return this.Imie + " " + this.Nazwisko;
    }
}
