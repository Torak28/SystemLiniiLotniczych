import mockit.FullVerificationsInOrder;
import org.junit.Before;
import org.junit.Test;
import mockit.integration.junit4.JMockit;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class DodanieSamolotuM{
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
	public void DodanieSamolotuM(){
		app.dodajSamolot("ErBas",1,400,true);
		assertEquals(nazwa, app.getFlota().get(0).getNazwa());
		assertEquals(liczba1, app.getFlota().get(0).getKlasaOdleglosci());
		assertEquals(liczba2, app.getFlota().get(0).getIloscMiejsc());
		assertEquals(stan, app.getFlota().get(0).getStan());

		assertTrue(app.getFlota().get(0).equals(testS));
	}
}