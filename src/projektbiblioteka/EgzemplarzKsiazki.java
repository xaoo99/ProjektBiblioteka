/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektbiblioteka;

/**
 * @author Mela Paulina, Migas Michal, Zimnicki Piotr
 */
public class EgzemplarzKsiazki 
{
    private Ksiazka Tytul;
    private int ID;
    private static int LastId = 0;
    
    public EgzemplarzKsiazki(Ksiazka tytul)
    {
        this.Tytul = tytul;
        EgzemplarzKsiazki.LastId++;
        this.ID = EgzemplarzKsiazki.LastId;
    };
    
    public Ksiazka getTytul(){return this.Tytul;};
    public int GetID(){return this.ID;};
    
    @Override
    public String toString()
    {
        return "" + this.ID + "\n" + this.Tytul;
    }
}
