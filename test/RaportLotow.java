import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import mockit.Expectations;
import mockit.integration.junit4.JMockit;
import mockit.Tested;
import mockit.Injectable;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;

@RunWith(JMockit.class)
public class RaportLotow{
	@Test
	public void DodawanieBiletuTest(){
		Aplikacja app = new Aplikacja();
		app.raportWszystkieLoty();
	}
}