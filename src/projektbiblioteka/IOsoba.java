/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektbiblioteka;

/**
 * Interfejs wymuszający umożliwienie zmany danych autora w klasach go implemenyujących
 * @author Mela Paulina, Migas Michal, Zimnicki Piotr
 */
public interface IOsoba 
{
    public boolean ZmienDane(String NoweImie, String NoweNazwisko);
    public boolean ZmienImie(String NoweImie);
    public boolean ZmienNazwisko(String NoweNazwisko);
}
