import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
    public void dodajLot(int MP, int MK, int D, int G){
        Lot lot = new Lot(MP, MK, D, G, wybierzSamolot());
        Loty.add(lot);
        for(int i = 0; i < Loty.size(); i++){
            if (Loty.get(i).getNumerLotu() == lot.getNumerLotu()){
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
        if (!Loty.isEmpty()) {
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
        }else{
            return null;
        }

        return Loty.get(idx);
    }
    public int formularzSzukajLot(){
		int MP, MK, D, G;
		Scanner in = new Scanner(System.in);
		System.out.print("Jakie miasto poczatkowe? ");
		MP = in.nextInt();
		System.out.print("Jakie miasto koncowe? ");
		MK = in.nextInt();
		System.out.print("Jaki dzien? ");
		D = in.nextInt();
		System.out.print("Jaka godzina? ");
		G = in.nextInt();
		return MP+MK+G+D;
	}
	public int formularzSzukajLot(int MP, int MK, int D, int G){
		return MP+MK+G+D;
	}
	public String raportWszystkieLoty(){
		String out = "Raport o wszystkich " + Flota.size() + " lotach:\n";
		for (int i = 0; i < Loty.size(); i++) {
			out += Loty.get(i).wygenerujRaport() + "\n";
		}
		return out;
	}
    public  Aplikacja(){

    }

    //Tymczasowe wywołanie
    public static void main(String[] args) {
        Aplikacja app = new Aplikacja();

        //Nazwa, klasa odleglosci, ilosc miejsc, stan techniczny
        app.dodajSamolot("ErBas",1,400,true);
        app.dodajSamolot("Tupolew",2,200,true);
        app.dodajSamolot("Boeing",2,500,true);

		//Nazwa
        app.usunSamolot("Tupolew");

		//Miasto Poczatkowe, Miasto Koncowe, Dzien, Godzina
        app.dodajLot(1,2,10,10); // 1 --> 2
        app.dodajLot(2,3,10,10); // 2 --> 3
        app.dodajLot(3,1,10,10); // 3 --> 1

		//Szukanie w oparciu o formularze
		// DO SPRAWDZENIA
		int szukany = app.formularzSzukajLot();
        app.szukajLotu(szukany).dodajBiletKupiony(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
		szukany = app.formularzSzukajLot();
		app.szukajLotu(szukany).dodajBiletKupiony(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
		szukany = app.formularzSzukajLot();
		app.szukajLotu(szukany).dodajBiletKupiony(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());

		szukany = app.formularzSzukajLot(1,2,10,10);
		app.szukajLotu(szukany).dodajBiletKupiony(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
		szukany = app.formularzSzukajLot(2,3,10,10);
		app.szukajLotu(szukany).dodajBiletKupiony(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
		szukany = app.formularzSzukajLot(3,1,10,10);
		app.szukajLotu(szukany).dodajBiletKupiony(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
        app.szukajLotu(4);

		//SPRAWDZENIE DODANIA
		szukany = app.formularzSzukajLot(1,2,10,10);
		System.out.println(app.szukajLotu(szukany).wygenerujRaport());
		szukany = app.formularzSzukajLot(1,2,10,10);
		System.out.println(app.szukajLotu(szukany).wygenerujRaport());
		szukany = app.formularzSzukajLot(1,2,10,10);
		System.out.println(app.szukajLotu(szukany).wygenerujRaport());

		//To tez nie dziala xd :c
        app.usunLot(1);

		System.out.println(app.raportWszystkieLoty());


		/*
		TODO:
		* przejrzec samolot.java
		* przejrzec bilet.java
		* dodac miejsce do biletu
		* Samolot po locie musi miec sprwdzanie stanu
		* Usuwanie Lotu i Samolotu nie ingeruje w tablice
		* Wypisanie wszystkich biletow, samolotow itp., itd.
		*
		 */
    }
}
