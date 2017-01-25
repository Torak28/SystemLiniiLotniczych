import org.junit.Before;
import org.junit.Test;
import mockit.integration.junit4.JMockit;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
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
	@Test
	public void dodajSamolot() throws Exception {
		app.dodajSamolot("ErBas",1,400,true);
		assertEquals("ErBas", app.getFlota().get(0).getNazwa());
		assertEquals(1, app.getFlota().get(0).getKlasaOdleglosci());
		assertEquals(400, app.getFlota().get(0).getIloscMiejsc());
		assertEquals("sprawny", app.getFlota().get(0).getStan());
		app.dodajSamolot("Tupolew",2,200,true);
		assertEquals("Tupolew", app.getFlota().get(1).getNazwa());
		assertEquals(2, app.getFlota().get(1).getKlasaOdleglosci());
		assertEquals(200, app.getFlota().get(1).getIloscMiejsc());
		assertEquals("sprawny", app.getFlota().get(1).getStan());
	}
}