/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektbiblioteka;

/**
 * Klasa abstrakcyjna zapewniająca występowanie niżej określonych pól w klasach 
 * dziedziczących
 * @author Mela Paulina, Migas Michal, Zimnicki Piotr
 */
public abstract class Osoba 
{
    protected String Imie;
    protected String Nazwisko;
    public String GetImie(){return this.Imie;};
    public String GetNazwisko(){return this.Nazwisko;};
}
