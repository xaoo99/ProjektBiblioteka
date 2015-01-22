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
    
    public Data(int DD, int MM, int RRRR)
    {
        if ( (DD < 1 || DD > 31 // Ogólny warunek błędnego dnia
            || (( MM == 4 || MM == 6 || MM == 9 || MM == 11 ) && DD > 30) //Warunek dla miesięcy o 30 dniach
            || (true) ) //BRAK WALIDACJI LUTEGO!!!
            || (MM > 12 || MM < 1) // Warunek poprawności miesięcy
            || (RRRR > 2015 || RRRR < 1990) ) //Warunek poprawności roku
        {
            this.Dzien = 1;
            this.Miesiac = 1;
            this.Rok = 1990;
        }
    }
}
