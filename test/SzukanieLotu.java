import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * Created by Torak28 on 23.01.2017.
 */
public class SzukanieLotu {
	@org.junit.Test
	public void dodajLot() throws Exception {
		Aplikacja app = new Aplikacja();
		app.dodajSamolot("ErBas",1,400,true);
		//Ustawienie Scannera na wejście
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		app.dodajLot(1,2,10,10);

		assertEquals(app.getLoty().get(0),app.szukajLotu(app.getLoty().get(0).generujNumerLotu()));

	}
}
