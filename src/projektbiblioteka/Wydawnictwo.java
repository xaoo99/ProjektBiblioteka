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
public class Wydawnictwo 
{
    private String Nazwa;
    private String Adres;
    
    public String GetNazwa(){return this.Nazwa;};
    public String GetAdres(){return this.Adres;};
    
    public boolean SetNazwa(String NowaNazwa){return false;};
    public boolean SetAdres(String NowyAdres){return false;};
    
    
    @Override
    public String toString()
    {
        return this.Nazwa + "/n" + this.Adres;
    }
}
