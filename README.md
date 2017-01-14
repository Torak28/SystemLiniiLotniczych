# SystemLiniiLotniczych

Przygotowali
 * Jarosław Ciołek-Żelechowski, **218386**
 * Dominik Cecotka, **218339**

#Diagram Przypadków Użycia:

![alt text](http://i.imgur.com/OY9q05y.png "Logo Title Text 1")


#Wymagania Funkcjonalne i niefunkcjonalne:
1. Lista wymagań funkcjonalnych:
	1. System zawiera rozkład lotów do którego można dodawać i usuwać poszczególne
elementy,
	2. Można dokonać zakupu biletu lub jego rezerwacji,
	3. Można wprowadzić wiele biletów o unikalnych numerach,
	4. System dopuszcza anulowanie zamówienia jeśli spełnione są warunki,
	5. Konsultant jest pracownikiem linii lotniczych, komunikuje się z klientami. Jego praca jest wspierana za pomocą systemu,
	6. Przeszukiwanie listy pasażerów danego Lotu w celu sprawdzenia czy rezerwacja/zakup biletu jest możliwy,
	7. Generowanie pełnej informacji o locie wraz z lista pasażerów i ich rozmieszczeniem w samolocie.

2. Lista wymagań niefunkcjonalnych:
	1. Dodawanie i usuwanie lotów obywa się tylko za pośrednictwem uprawnionych osób,
	2. Wstawianie nowych biletów oraz ich rezerwacja dokonywana jest przez klientów/pasażerów,
	3. Zakup oraz rezerwacja odbywają się za pośrednictwem Internetu lub specjalnie przygotowanych aplikacji,
	4. Rezerwacje należy potwierdzić maksymalnie dzień przed lotem.

#Założenia, uproszcznia:
Na etapie projektowym założyliśmy dwie kluczowe dla Naszego Diagramu Klas założenia:

 * Nasza aplikacja na potrzeby pokazania funkcjonalności nie będzie wymagała systemu bazodanowego. Mając jednak w głowie „rozwój” Naszego systemy zdecydowaliśmy się poszczególne „rekordy” bazy danych przechowywać w wektorach. Tym samym sposób korzystania z nich wymaga używania indeksów, podobnie jak w przypadku Bazy Danych, a oprócz tego zamiana tych pól na takie wykorzystujące zapytania SQL nie będzie bolesny w implementacji

 * Każde pole w Naszej aplikacji ma funkcję set() i get(). Mamy świadomość że tworzenie tych funkcji dla każdego atrybuty klasy jest zbędne. Wydaje się nam jednak że na etapie projektowym doszukiwanie się tej zbędności może powodować niepotrzebne komplikacje. Zakładamy że prościej będzie w etapie implementacyjnym usunąć te funkcje set() i get() dla których nie znaleźliśmy zastosowania.

#Diagram Klas:

![alt text](http://i.imgur.com/v6eBz8o.png "Logo Title Text 1")

###Komentarz do Diagramu:
Przede wszystkim podczas projektowania Klas kierowaliśmy się pełną enkapsulacją oraz maksymalnym ograniczeniem i uproszczeniem danych. Są jednak pewne elementy, które wymagają szczególnej uwagi oraz dodatkowego komentarza:
 * Klasa Lot posiada wektor Biletów, które do Niego przynależą. Wynika to z tego że Lot z Biletami jest szczególnie powiązany i bezsensowne byłoby chociażby osobne usuwanie Biletu w wypadku usuwania Lotu. Tym samym jednak dodawanie rezerwacji, czy zakup biletu kontrolowany jest z poziomu Klasy Lot, wywoływanej w Klasie Aplikacja,
 * Generowanie Raportu jest funkcją Klasy Lot co z jednej strony wynika z faktu że Klasa Lot przechowuje należące do konkretnego Lotu bilety, a z drugiej z firmy przechowywania danych, tj. wektora Lotów w postaci tablicowej,
 * Klasa Lot posiada również przypisany do niej Samolot oraz funkcje get() i set() w celu pobrania informacji o Samolocie oraz możliwość zmiany Samolotu, w przypadku np. awarii,
 * Klasa Samolot posiada atrybut: klasaOdleglosci, który to mówi jak daleko Nasz Samolot jest w stanie polecieć, oraz definiuje jego pojemność pasażerską
 * Klasa Aplikacja jest klasą-Fasadą. Jest sercem Aplikacji i głównym obiektem służącym do sterowania całością

#Diagramy Sekwencji:

###Zakup Biletu
![alt text](http://i.imgur.com/dNMZx9p.png "Logo Title Text 1")

Wywołanie:
```java
app.szukajLotu(1).dodajBiletKupiony(2, 1, 2, 5, 5, 5);
```
.szukajLotu:
```java
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
```
.dodajBiletKupiony:
```java
public boolean dodajBiletKupiony(int mp, int mk, int d, int g){
        if(iloscZarezerwowanych + iloscKupionych < samolot.getIloscMiejsc())
        {
            Bilet bilet = new Bilet(generujNumerLotu(),1,mp,mk,d,g,Bilety.size()+1);
            Bilety.add(bilet);
            System.out.println("Bilet kupionoy zostal dodany do tego lotu.\n");
            iloscKupionych++;
            return true;
        }
        else {
            System.out.println("Brak miejsc w samolocie.\n");
            return false;
        }
    }
```

###Rezerwazcja Biletu
![alt text](http://i.imgur.com/d6NyKV8.png "Logo Title Text 1")

Wywołanie:
```java
app.szukajLotu(1).dodajBiletZarezerwowany(2, 1, 5, 5, 5, 5);
```

.dodajBiletZarezerwowany
```java
public boolean dodajBiletZarezerwowany(int mp, int mk, int d, int g){
        if(iloscZarezerwowanych + iloscKupionych < samolot.getIloscMiejsc())
        {
            Bilet bilet = new Bilet(generujNumerLotu(),0,mp,mk,d,g,Bilety.size()+1);
            Bilety.add(bilet);
            System.out.println("Bilet zarezerwowany zostal dodany do tego lotu.\n");
            iloscZarezerwowanych++;
            return true;
        }
        else {
            System.out.println("Brak miejsc w samolocie.\n");
            return false;
        }
    }
```

###Dodanie Lotu
![alt text](http://i.imgur.com/IfRCQzu.png "Logo Title Text 1")

Wywołanie:
```java
app.dodajLot(1,2,10,10);
```

.dodajLot:
```java
public void dodajLot(int MP, int MK, int D, int G){
		if (!czyTakiLotJuzIstnieje(MP+MK+D+G)){
			if (czyMamSamolotDoLotu()){
				Scanner in = new Scanner(System.in);
				System.out.println(raportSamoloty());
				System.out.println("Który Samolot chcesz dodać do tego lotu? ");
				int index = in.nextInt()-1;
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
```

**Dygresja:** Zamieszczona na Diagramie Sekwencji Funkcja *szukajLot()* jest zastępiona w kodzie funkcją *czyTakiLotJuzIstnieje()*, która jest jej uproszczeniem,


###Szukanie lotu
![alt text](http://i.imgur.com/P79AGA8.png "Logo Title Text 1")

Wywołanie:
```java
app.szukajLotu(1);
```

.szukajLotu:
```java
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
```
