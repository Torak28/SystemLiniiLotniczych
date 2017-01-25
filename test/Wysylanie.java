import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * Created by Torak28 on 23.01.2017.
 */
public class Wysylanie {
	Aplikacja app = new Aplikacja();
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Before
	public void setup(){
		app.dodajSamolot("ErBas",1,400,true);
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		app.dodajLot(1,2,10,10);
	}
	@Test
	public void Wysylanie() throws Exception{
		ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
		System.setIn(in);
		app.wyslijLot(app.getLoty().get(0).getNumerLotu());
		assertEquals("niesprawny", app.getLoty().get(0).getSamolot().getStan());
	}
}
