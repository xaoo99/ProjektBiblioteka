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
public class Data 
{
    private int Dzien;
    private int Miesiac;
    private int Rok;
    
    private static int Dzien0 = 1;
    private static int Miesiac0 = 1;
    private static int Rok0 = 1990;
    
    public Data(int DD, int MM, int RRRR)
    {
        this.SetData(DD, MM, RRRR);
    }
    public Data(){this(1,1,1990);};
    
    public boolean SetData(int DD, int MM, int RRRR)
    {
        if ( Data.DataOk(DD, MM, RRRR) )//Uwzględnić datę po dniu dzisiejszym
        {
            this.Dzien = DD;
            this.Miesiac = MM;
            this.Rok = RRRR;
            return true;
        }
        this.Dzien = Data.Dzien0;
        this.Miesiac = Data.Miesiac0;
        this.Rok = Data.Rok0;
        return false;
    }
    
    public int GetDzien(){return this.Dzien;};
    public int GetMiesiac(){return this.Miesiac;};
    public int GetRok(){return this.Rok;};
    
    public boolean IsAfterOrEqual(Data DrugaData)
    {
        if (this.Rok >= DrugaData.GetRok() || this.Rok == DrugaData.GetRok() && ((this.Miesiac >= DrugaData.GetMiesiac()) || this.Miesiac == DrugaData.GetMiesiac() && (this.Dzien >= DrugaData.GetDzien())))
            return true;
        return false;
    }
    private static boolean DataOk(int DD, int MM, int RRRR)
    {
        if ( (DD < 1 || DD > 31 // Ogólny warunek błędnego dnia
            || (( MM == 4 || MM == 6 || MM == 9 || MM == 11 ) && DD > 30) //Warunek dla miesięcy o 30 dniach
            || ((RRRR%4 == 0 && RRRR%100 != 0) || RRRR%400 == 0) && DD>28) //Walidacja lutego
            || (MM > 12 || MM < 1) // Warunek poprawności miesięcy
            || (RRRR > 2015 || RRRR < 1990) ) //Warunek poprawności roku
            return false;
        return true;
    }
    /**
     * Metoda będzie kiedyś (?) zwracała aktualną datę z systemu.
     */
    public Data GetCurrentDate()
    {
        return new Data();
    }
    @Override
    public String toString()
    {
        return "" + this.Dzien + "-" + this.Miesiac + "-" + this.Rok;
    }
}
