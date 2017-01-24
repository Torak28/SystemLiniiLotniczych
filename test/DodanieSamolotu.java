import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Torak28 on 23.01.2017.
 */
public class DodanieSamolotu {
	@org.junit.Rule
	public ExpectedException exception = ExpectedException.none();
	Aplikacja app = new Aplikacja();
	@org.junit.Test
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