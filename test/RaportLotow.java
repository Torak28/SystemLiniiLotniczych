import org.junit.Test;
import mockit.integration.junit4.JMockit;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class RaportLotow{
	@Test
	public void DodawanieBiletuTest(){
		Aplikacja app = new Aplikacja();
		app.raportWszystkieLoty();
	}
}