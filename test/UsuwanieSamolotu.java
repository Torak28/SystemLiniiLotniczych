import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by Torak28 on 23.01.2017.
 */
public class UsuwanieSamolotu {
	Aplikacja app = new Aplikacja();
	@org.junit.Before
	public void setup(){
		app.dodajSamolot("ErBas",1,400,true);
		app.dodajSamolot("Tupolew",2,200,true);
		app.dodajSamolot("Orzel",2,500,true);
	}
	@org.junit.Test
	public void usunSamolot() throws Exception {
		app.usunSamolot("Tupolew");
		assertEquals("Orzel", app.getFlota().get(1).getNazwa());
		assertEquals(2, app.getFlota().get(1).getKlasaOdleglosci());
		assertEquals(500, app.getFlota().get(1).getIloscMiejsc());
		assertEquals("sprawny", app.getFlota().get(1).getStan());
	}

}