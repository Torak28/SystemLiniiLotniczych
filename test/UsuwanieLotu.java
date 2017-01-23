import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by Torak28 on 23.01.2017.
 */
public class UsuwanieLotu {
	@org.junit.Test
	public void dodajLot() throws Exception {
		Aplikacja app = new Aplikacja();
		app.dodajSamolot("ErBas",1,400,true);

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

		app.usunLot(app.getLoty().get(0).getNumerLotu());
		assertEquals(true, app.getLoty().isEmpty());
	}
}