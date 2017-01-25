# SystemLiniiLotniczych

Przygotowali
 * Jarosław Ciołek-Żelechowski, **218386**
 * Dominik Cecotka, **218339**
 
## Idea
Zgodnie z samą ideą testowania postanowiliśmy przede wszystkim rozbić testy na wiele instancji i staraliśmy się testować po jenej metodzie danj klasy w danej instancji. Ważne dla Nas było wykorzystanie adnotacji *@Before* do uprzedniego przygotowania Naszej klasy, oraz *@Rule* do sprawdzania czy nie wysępuje jakiś wyjątek. Wszystkie testy zostały napisane w InteliJ i musze przyznać że doadatek obsługujący testy w tym IDE jest niezwukle przydatny. Sam generuje większość potrzebnego kodu, a do tego umożliwia sprawdzenie pokrycia testami kodu Naszej aplikacji, co daje niejako odzwierciedlenie tego ile zrobiliśmy i ile jeszcze musimy sprawdzić.

### Dodanie Lotu 
 ```java
public class DodanieLotu {
	Aplikacja app = new Aplikacja();
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Before
	public void setup(){
		app.dodajSamolot("ErBas",1,400,true);
	}
	@Test
	public void dodajLot() throws Exception {
		//Ustawienie Scannera na wejście
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);

		app.dodajLot(1,2,10,10);
		assertEquals(1, app.getLoty().get(0).getMiastoPoczatkowe());
		assertEquals(2, app.getLoty().get(0).getMiastoKoncowe());
		assertEquals(10, app.getLoty().get(0).getGodzina());
		assertEquals(10, app.getLoty().get(0).getData());
		assertEquals(0, app.getLoty().get(0).getIloscKupionych());
		assertEquals(0, app.getLoty().get(0).getIloscZarezerwowanych());
		assertEquals(23, app.getLoty().get(0).getNumerLotu());

	}
}
 ```
 
 Jak widać całość można podzielić na sekcje przygotowującą klasę do testów, jak i sam test. By Dodać Lot, musimy pierw posiadać Samolot, który może posłużyć do obsługi tego Lotu. Dlatego w sekcji setup dodajemy Samolot. Dalej w samym teście ustawiamy *System.in* na 1, tak żeby w funkcji *.dodajLot* przydzielić mu samolot o indeksie 1, czyli ten który w funkcji *setup()* dodaliśmy. Sam test za to sprowadza się do pobrania z aplikacja Listy Loty, a następnie z Niej pobranie elementu o indeksie 0. Nastepnie porównuje przy pomocy *assertEquals()* czy faktycznie w Naszej Liście znajduje się Lot o parametrach przeze mnie zadanych
 
 ### Dodanie Samolotu
 
 ```java
 public class DodanieSamolotu {
 	Aplikacja app = new Aplikacja();
 	String nazwa, stan;
 	int liczba1, liczba2;
 	Samolot testS;
 
 	@Before
 	public void setup() {
 		nazwa = "ErBas";
 		liczba1 = 1;
 		liczba2 = 400;
 		stan = "sprawny";
 		testS = new Samolot("ErBas",1,400,true);
 	}
 	@Test
 	public void DodanieSamolotu(){
 		app.dodajSamolot("ErBas",1,400,true);
 		assertEquals(nazwa, app.getFlota().get(0).getNazwa());
 		assertEquals(liczba1, app.getFlota().get(0).getKlasaOdleglosci());
 		assertEquals(liczba2, app.getFlota().get(0).getIloscMiejsc());
 		assertEquals(stan, app.getFlota().get(0).getStan());
 		//Porownanie
 		String expResult = "ErBas";
 		String result = app.getFlota().get(0).getNazwa();
 		assertEquals(expResult,result);
 		//Porownanie calego obiektu
 		assertTrue(app.getFlota().get(0).equals(testS));
 	}
 }
  ```
Dla metody *dodajSamolot()* przeprowadziłem testowanie dwuetapowe. Pierw dodaje Samolot i sprawdzam ustawione przez konstruktor parametry są zgodne z tymi co podałem, a następnie sam tworzę w skecji *@Before* Samolot o zadanych parametrach i porównuje je przeciążona metodą *equals()*, tym samym mając pewność że mam tutaj do czynienia z tym samym :)
  
### Dalesze Testy
  
Reszta testowania jest utrzymana dokładnie w tej samym tonie. Kodu nie przeklejam, bo i tak jest tutaj dostępny.
![alt text](http://i.imgur.com/nNaQfkw.png "Logo Title Text 1")
