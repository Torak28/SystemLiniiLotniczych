import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Torak28 on 20.12.2016.
 */
public class Aplikacja {
    private List<Samolot> Flota = new ArrayList<Samolot>();
    private List<Lot> Loty = new ArrayList<Lot>();
    private Random g = new Random();

    public void dodajSamolot(String NAZWA, int KO, int IM, boolean S){
        Samolot sam = new Samolot(NAZWA,KO,IM,S);
        Flota.add(sam);
        System.out.println("Samolot o nastepujacych parametrach zostal dodany: \nKlasa odleglosci: "+
                Flota.get(Flota.size() - 1).getKlasaOdleglosci()+"\n"+
                "Ilosc miejsc: "+
                Flota.get(Flota.size() - 1).getIloscMiejsc()+"\n"+
                "Stan samolotu: "+
                Flota.get(Flota.size() - 1).getStan()+"\n");
    }
    public boolean  usunSamolot(String N){
        for(int i = 0; i < Flota.size(); i++){
            if(N == Flota.get(i).getNazwa()){
                System.out.println("Samolot o nazwa: "+N+" został usuniety.\n");
                Flota.remove(i);
                break;
            }
        }
        return true;
    }
    public void dodajLot(int NL, int IK, int IZ){
        Lot lot = new Lot(NL, IK, IZ, wybierzSamolot());
        for(int i = 0; i < Loty.size(); i++){
            if (Loty.get(i).getNumerLotu() == NL){
                Loty.add(lot);
                System.out.println("Lot o nastepujacych parametrach zostal dodany: \nNumer lotu: "+
                        Loty.get(Loty.size() - 1).getNumerLotu()+"\n"+
                        "Przydzielony samolot: \nNazwa: "+
                        Loty.get(Loty.size() - 1).getSamolot().getNazwa()+"\n"+
                        "Klasa odleglosci: "+
                        Loty.get(Loty.size() - 1).getSamolot().getKlasaOdleglosci()+"\n"+
                        "Ilosc miejsc: "+
                        Loty.get(Loty.size() - 1).getSamolot().getIloscMiejsc()+"\n"+
                        "Stan samolotu: "+
                        Loty.get(Loty.size() - 1).getSamolot().getStan()+"\n");
            } else {
                System.out.println("Nie mozna dodac danego lotu. Dany Lot juz istnieje");
            }
        }

    }
    public Samolot wybierzSamolot(){
        int losowySamolot = g.nextInt(Flota.size());
        return Flota.get(losowySamolot);
    }
    public void usunLot(int NL){
        for(int i = 0; i < Loty.size(); i++){
            if(NL == Loty.get(i).getNumerLotu()){
                System.out.println("Lot o numerze: "+NL+" został usuniety.");
                Loty.remove(i);
                break;
            }
        }
    }
    // Szuka lotu o danym Numerze Lotu
    public Lot szukajLotu(int NL){
        int iloscLotow = Loty.size();
        int idx = 0;
        for (int i = 0; i < iloscLotow; i++) {
            if (Loty.get(i).getNumerLotu() == NL) {
                System.out.println("Lot o numerze: "+NL+" został znaleziony.");
                idx = i;
                break;
            }
            else if(i == iloscLotow - 1){
                System.out.println("Lot o numerze: "+NL+" nie został znaleziony.");
                return null;
            }
        }
        return Loty.get(idx);
    }

    public  Aplikacja(){

    }
    //Tymczasowe wywołanie
    public static void main(String[] args) {
        Aplikacja app = new Aplikacja();

        app.dodajSamolot("ErBas",1,400,true);
        app.dodajSamolot("Tupolew",2,200,true);
        app.dodajSamolot("Boeing",2,500,true);

        app.usunSamolot("Tupolew");

        app.dodajLot(1, 0, 0);
        app.dodajLot(2, 0, 0);
        app.dodajLot(3, 0, 0);

        app.szukajLotu(1).dodajBiletKupiony(2, 1, 2, 5, 5, 5);
        app.szukajLotu(2).dodajBiletKupiony(2, 1, 2, 5, 3, 5);
        app.szukajLotu(3).dodajBiletKupiony(2, 1, 5, 6, 8, 5);
        app.szukajLotu(1).dodajBiletZarezerwowany(2, 1, 5, 5, 5, 5);
        app.szukajLotu(2).dodajBiletZarezerwowany(2, 1, 6, 5, 3, 5);
        app.szukajLotu(3).dodajBiletZarezerwowany(2, 1, 9, 6, 8, 5);
        app.szukajLotu(4);

        app.usunLot(1);
    }
}
