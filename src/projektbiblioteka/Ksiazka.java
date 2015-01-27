/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektbiblioteka;

/**
 * @author Mela Paulina, Migas Michal, Zimnicki Piotr
 */
public class Ksiazka 
{
    private String Tytul;
    private String ISBN;
    private Gatunek Gatunek;
    private Autor Autor;
    private Wydawnictwo Wydawnictwo;
    
    
    public Ksiazka(String tytul, String isbn, Autor autor, Gatunek gatunek, Wydawnictwo wydawnictwo)
    {
        this.Tytul = tytul;
        this.ISBN = isbn;
        if (autor == null)
            this.Autor = new Autor();
        else
            this.Autor = autor;
        if (gatunek == null)
            this.Gatunek = new Gatunek();
        else
            this.Gatunek = gatunek;
        if (wydawnictwo == null)
            this.Wydawnictwo = new Wydawnictwo();
        else
            this.Wydawnictwo = wydawnictwo;
    }
    public Ksiazka(){this("","",null,null,null);};
    
    public String GetTytul(){return this.Tytul;};
    public String GetISBN(){return this.ISBN;};
    public Gatunek GetGatunek(){return this.Gatunek;};
    public Autor GetAutor(){return this.Autor;};
    public Wydawnictwo GetWydawnictwo(){return this.Wydawnictwo;};
    
    public boolean SetTytul(String NowyTytul){return false;};
    public boolean SetISBN(String NowyTytul){return false;};
    public boolean SetGatunek(String NowyTytul){return false;};
    public boolean SetAutor(String NowyTytul){return false;};
    public boolean SetWydawnictwo(String NowyTytul){return false;};
    
    @Override
    public String toString()
    {
        return this.Tytul + "\n" 
             + this.Autor.toString() + "\n"
             + this.Wydawnictwo.toString() + "\n"
             + this.ISBN + "\n"
             + this.Gatunek.toString();
    }
}
