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
public class Gatunek 
{
    private String Nazwa;
    
    public Gatunek(String Nazwa){this.Nazwa = Nazwa;};
    public Gatunek(){this("");};
    
    public void SetNazwa(String NowaNazwa){this.Nazwa = NowaNazwa;};
    public String GetNazwa(){return this.Nazwa;};
}
