import java.util.ArrayList;
import java.util.List;

/**
 * Created by Torak28 on 20.12.2016.
 */
public class Aplikacja {
    private List<Samolot> Flota = new ArrayList<Samolot>();
    private List<Lot> Loty = new ArrayList<Lot>();

    public Lot getLot(int NL){
        int iloscSamolotow = Loty.size();
        for (int i = 0; i < iloscSamolotow; i++) {
            if (Loty.get(i).getNumerLotu() == NL) {
                return Loty.get(i);
            }
        }
        //defaltowy zwrot
        return Loty.get(0);
    }
    public boolean dodajSamolot(){
        return true;
    }
    public boolean usunSamolot(){
        return true;
    }
    public boolean dodajLot(){
        return true;
    }
    public boolean usunLot(){
        return true;
    }
    public boolean szukajSamolotu(int ID){
        return true;
    }
    public boolean szukajLotu(int NL){
        int iloscSamolotow = Loty.size();
        for (int i = 0; i < iloscSamolotow; i++) {
            if (Loty.get(i).getNumerLotu() == NL) {
                return true;
            }
        }
        return false;
    }
    public  Aplikacja(int a){
        //Dodanie 3 Samolotow o klasie odleglosci 1, ilosci miejsc rownej 100 i stanie true
        Samolot samolotA = new Samolot(1, 100, true);
        Flota.add(samolotA);
        Samolot samolotB = new Samolot(1, 100, true);
        Flota.add(samolotB);
        Samolot samolotC = new Samolot(1, 100, true);
        Flota.add(samolotC);
        //Doadnie Lotow na trasach:
        //Trasy 1-2, 2-3, 3-1
        Lot lot12 = new Lot(12, 0, 0, Flota.get(0));
        Lot lot23 = new Lot(23, 0, 0, Flota.get(1));
        Lot lot31 = new Lot(31, 0, 0, Flota.get(2));
        Loty.add(lot12);
        Loty.add(lot23);
        Loty.add(lot31);
    }
    //Tymczasowe wywołanie
    public static void main(String[] args) {
        /*TODO:
         * Zakup biletu
         * Rezerwacja Biletu
         * Dodanie Lotu
         */
        Aplikacja aplikacja = new Aplikacja(0);


        //dodaje bilet do konkretnego lotu
        aplikacja.szukajLotu(12);


        System.out.println(31/10);
    }
}
