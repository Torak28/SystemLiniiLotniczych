import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * Created by Torak28 on 23.01.2017.
 */
public class DodawanieBiletu {
	@org.junit.Test
	public void dodajBilet() throws Exception{
		Aplikacja app = new Aplikacja();
		app.dodajSamolot("ErBas",1,400,true);
		//Ustawienie Scannera na wejście
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		app.dodajLot(1,2,10,10);

		app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).dodajBiletKupiony(app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoPoczatkowe(),app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoKoncowe(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getData(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getGodzina() );

		assertEquals(1, app.getLoty().get(0).getIloscKupionych());
		assertEquals(0, app.getLoty().get(0).getIloscZarezerwowanych());
		assertEquals(app.getLoty().get(0).getBilety().get(0).getMiastoPoczatkowe(), app.getLoty().get(0).getMiastoPoczatkowe());
		assertEquals(app.getLoty().get(0).getBilety().get(0).getMiastoKoncowe(), app.getLoty().get(0).getMiastoKoncowe());
		assertEquals(app.getLoty().get(0).getBilety().get(0).getData(), app.getLoty().get(0).getData());
		assertEquals(app.getLoty().get(0).getBilety().get(0).getGodzina(), app.getLoty().get(0).getGodzina());
		assertEquals(app.getLoty().get(0).getBilety().get(0).getNumerLotu(), app.getLoty().get(0).getNumerLotu());
		assertEquals(1,app.getLoty().get(0).getBilety().get(0).getMiejsce());

		app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).dodajBiletZarezerwowany(app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoPoczatkowe(),app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoKoncowe(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getData(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getGodzina() );

		assertEquals(1, app.getLoty().get(0).getIloscKupionych());
		assertEquals(1, app.getLoty().get(0).getIloscZarezerwowanych());
		assertEquals(app.getLoty().get(0).getBilety().get(1).getMiastoPoczatkowe(), app.getLoty().get(0).getMiastoPoczatkowe());
		assertEquals(app.getLoty().get(0).getBilety().get(1).getMiastoKoncowe(), app.getLoty().get(0).getMiastoKoncowe());
		assertEquals(app.getLoty().get(0).getBilety().get(1).getData(), app.getLoty().get(0).getData());
		assertEquals(app.getLoty().get(0).getBilety().get(1).getGodzina(), app.getLoty().get(0).getGodzina());
		assertEquals(app.getLoty().get(0).getBilety().get(1).getNumerLotu(), app.getLoty().get(0).getNumerLotu());
		assertEquals(2,app.getLoty().get(0).getBilety().get(1).getMiejsce());
	}
}
