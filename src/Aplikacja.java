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
    public boolean czyMamSamolotDoLotu(){
		int tmp = 0;
		for (int i = 0; i < Flota.size(); i++) {
			if (Flota.get(i).getNumerLotu() != 0)
				tmp += 1;
		}
		if (tmp == Flota.size())
			return false;
		else
			return true;
	}
	public boolean czyTakiLotJuzIstnieje(int NL){
		int tmp = 0;
		for (int i = 0; i < Flota.size(); i++) {
			if (Flota.get(i).getNumerLotu() == NL)
				tmp = 1;
		}
		if (tmp == 1)
			return true;
		else
			return false;
	}
    public void dodajLot(int MP, int MK, int D, int G){
		if (!czyTakiLotJuzIstnieje(MP+MK+D+G)){
			Scanner in = new Scanner(System.in);
			System.out.println(raportSamoloty());
			System.out.println("Który Samolot chcesz dodać do tego lotu? ");
			int index = in.nextInt()-1;
			if (czyMamSamolotDoLotu()){
				Lot lot = new Lot(MP, MK, D, G, Flota.get(index));
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
			}else {
				System.out.println("Nie mozna dodac danego lotu. Nie mamy dla niego Samolotu");
			}
		}else{
			System.out.println("Nie mozna dodac danego lotu. Taki lot juz istnieje");
		}
    }
    public int szukajSamolot(int NL){
		for (int i = 0; i < Flota.size(); i++) {
			if (Flota.get(i).getNumerLotu() == NL){
				return i;
			}else {
				return -1;
			}
		}
		return 666;
	}
    public Samolot wybierzSamolot(){
        int losowySamolot = g.nextInt(Flota.size());
        return Flota.get(losowySamolot);
    }
    public String raportSamoloty(){
		String out = "Wszystkie Samoloty:\n";
		for (int i = 0; i < Flota.size(); i++) {
			out += "\t" + (i+1) + ": " + Flota.get(i).getNazwa() + "\n\tStan: " + Flota.get(i).getStan() + "\n\tIlość Miejsc: " + Flota.get(i).getIloscMiejsc() + "\n";
			if (Flota.get(i).getNumerLotu() != 0){
				out += "\tObsługuje Lot: " + Flota.get(i).getNumerLotu() + "\n";
			}else{
				out += "\tNie używany w żadnym locie\n";
			}
		}
		return out;
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
    // Szuka lotu o danym Numerze Lotu WAT
    public Lot szukajLotu(int NL){
        int idx = 0;
        if (!Loty.isEmpty()) {
			if (czyTakiLotJuzIstnieje(NL)){
				for (int i = 0; i < Loty.size(); i++) {
					if (Loty.get(i).getNumerLotu() == NL) {
						idx = i;
					}
				}
			}else {
				System.out.println("Nie ma takiego lotu");
				return null;
			}
        }else{
			System.out.println("Nie ma żadnych Lotów");
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
		String out = "Raport o wszystkich " + Loty.size() + " lotach:\n";
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
		Scanner in = new Scanner(System.in);

		//PYTANIE O TRYB ODPALENIA

        //Nazwa, klasa odleglosci, ilosc miejsc, stan techniczny
		//DZIALA
        app.dodajSamolot("ErBas",1,400,true);
        app.dodajSamolot("Tupolew",2,200,true);
        app.dodajSamolot("Boeing",2,500,true);
		app.dodajSamolot("Orzel",2,500,true);

		//Nazwa
		//DZIALA
        app.usunSamolot("Tupolew");

		//Miasto Poczatkowe, Miasto Koncowe, Dzien, Godzina
		//DZIALA
        app.dodajLot(1,2,10,10); // 1 --> 2
        app.dodajLot(2,3,10,10); // 2 --> 3
        app.dodajLot(3,1,10,10); // 3 --> 1
		System.out.println(app.raportWszystkieLoty());

		//Szukanie w oparciu o formularze
		// DZIALA
		System.out.println("Dodanie Biltu o parametrach:\n");
		int szukany = app.formularzSzukajLot();
        app.szukajLotu(szukany).dodajBiletKupiony(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
		System.out.println("Dodanie Biltu o parametrach:\n");
		szukany = app.formularzSzukajLot();
		app.szukajLotu(szukany).dodajBiletKupiony(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
		System.out.println("Dodanie Biltu o parametrach:\n");
		szukany = app.formularzSzukajLot();
		app.szukajLotu(szukany).dodajBiletKupiony(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
		System.out.println(app.raportWszystkieLoty());

		szukany = app.formularzSzukajLot(1,2,10,10);
		app.szukajLotu(szukany).dodajBiletZarezerwowany(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
		szukany = app.formularzSzukajLot(2,3,10,10);
		app.szukajLotu(szukany).dodajBiletZarezerwowany(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
		szukany = app.formularzSzukajLot(3,1,10,10);
		app.szukajLotu(szukany).dodajBiletZarezerwowany(app.szukajLotu(szukany).getMiastoPoczatkowe(), app.szukajLotu(szukany).getMiastoKoncowe(), app.szukajLotu(szukany).getData(), app.szukajLotu(szukany).getGodzina());
		System.out.println(app.raportWszystkieLoty());

		//SPRAWDZNIE JAK NIE MA TAKIEGO LOTU
		//DZIALA
		app.szukajLotu(4);

		//SPRAWDZENIE DODANIA
		//DZIALA
		System.out.println("Usuwanie Biltu o parametrach:\n");
		szukany = app.formularzSzukajLot(1,2,10,10);
		System.out.println(app.szukajLotu(szukany).wygenerujRaport());
		szukany = app.formularzSzukajLot(2,3,10,10);
		System.out.println(app.szukajLotu(szukany).wygenerujRaport());
		szukany = app.formularzSzukajLot(3,1,10,10);
		System.out.println(app.szukajLotu(szukany).wygenerujRaport());

		//USUWANIE DO SPRAWDZENIA
		System.out.println("Raport Biletowy dla Lotu o parametrach:\n");
		szukany = app.formularzSzukajLot();
		System.out.println(app.szukajLotu(szukany).raportBilety());
		System.out.println("Jaki usunąć?(Podaj miejsce) ");
		int miejsce = in.nextInt();
		app.szukajLotu(szukany).usunBiletKupiony(miejsce);
		System.out.println("Jaki usunąć?(Podaj miejsce) ");
		miejsce = in.nextInt();
		app.szukajLotu(szukany).usunBiletZarezerwowany(miejsce);

		//SPRAWDZENIE USUWANIA I POPRAWNOSCI GENEROWANIA RAPORTOW O WSZYSTKIM
		//DZIALA
		System.out.println(app.raportWszystkieLoty());

		//USUWANIE LOTU
		//DZIALA
		System.out.println("Jaki Lot usunąć?");
		szukany = app.formularzSzukajLot();
		app.usunLot(szukany);
		System.out.println(app.raportWszystkieLoty());

		/*
		TODO:
		* Samolot po locie musi miec sprwdzanie stanu
		* Tryb Odpalenia
		 */
    }
}
