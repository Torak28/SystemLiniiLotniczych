import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * Created by Torak28 on 23.01.2017.
 */
public class UsuwanieBiletu {
	@org.junit.Test
	public void UsuwanieBiletu(){
		Aplikacja app = new Aplikacja();
		app.dodajSamolot("ErBas",1,400,true);
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		app.dodajLot(1,2,10,10);

		//Dwa kupione 1,2
		app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).dodajBiletKupiony(app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoPoczatkowe(),app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoKoncowe(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getData(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getGodzina() );
		app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).dodajBiletKupiony(app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoPoczatkowe(),app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoKoncowe(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getData(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getGodzina() );
		//Dwa zarezerwowane 3,4
		app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).dodajBiletZarezerwowany(app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoPoczatkowe(),app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoKoncowe(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getData(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getGodzina() );
		app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).dodajBiletZarezerwowany(app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoPoczatkowe(),app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getMiastoKoncowe(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getData(), app.szukajLotu(app.getLoty().get(0).generujNumerLotu()).getGodzina() );

		app.szukajLotu(app.getLoty().get(0).getNumerLotu()).usunBiletKupiony(2);
		assertEquals(false, app.getLoty().get(0).szukajBiletu(2));

		app.szukajLotu(app.getLoty().get(0).getNumerLotu()).usunBiletZarezerwowany(3);
		assertEquals(false, app.getLoty().get(0).szukajBiletu(3));

		app.szukajLotu(app.getLoty().get(0).getNumerLotu()).usunBiletKupiony(2);
		app.szukajLotu(app.getLoty().get(0).getNumerLotu()).usunBiletZarezerwowany(3);
	}
}
