/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektbiblioteka;

/**
 *
 * @author student
 */
public class Autor extends Osoba implements IOsoba 
{
    @Override
    public boolean ZmienDane(String NoweImie, String NoweNazwisko){return false;};
    @Override
    public boolean ZmienImie(String NoweImie){return false;};
    @Override
    public boolean ZmienNazwisko(String NoweNazwisko){return false;};
}
