import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Torak28 on 23.01.2017.
 */
public class UsuwanieSamolotu {
	Aplikacja app = new Aplikacja();
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Before
	public void setup(){
		app.dodajSamolot("ErBas",1,400,true);
		app.dodajSamolot("Tupolew",2,200,true);
		app.dodajSamolot("Orzel",2,500,true);
	}
	@Test
	public void usunSamolot() throws Exception {
		app.usunSamolot("Tupolew");
		assertEquals("Orzel", app.getFlota().get(1).getNazwa());
		assertEquals(2, app.getFlota().get(1).getKlasaOdleglosci());
		assertEquals(500, app.getFlota().get(1).getIloscMiejsc());
		assertEquals("sprawny", app.getFlota().get(1).getStan());
	}

}