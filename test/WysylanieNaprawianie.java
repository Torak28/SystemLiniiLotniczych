import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * Created by Torak28 on 23.01.2017.
 */
public class WysylanieNaprawianie {
	@org.junit.Test
	public void WysylanieNaprawianie() throws Exception{
		Aplikacja app = new Aplikacja();
		app.dodajSamolot("ErBas",1,400,true);
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		app.dodajLot(1,2,10,10);

		in = new ByteArrayInputStream("2".getBytes());
		System.setIn(in);
		app.wyslijLot(app.getLoty().get(0).getNumerLotu());
		assertEquals("niesprawny", app.getLoty().get(0).getSamolot().getStan());
		app.naprawSamolot(app.getLoty().get(0).getNumerLotu());
		assertEquals("sprawny", app.getLoty().get(0).getSamolot().getStan());
	}
}
