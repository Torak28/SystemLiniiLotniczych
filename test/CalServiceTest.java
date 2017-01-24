/**
 * Created by Torak28 on 24.01.2017.
 */

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
/*
* MOckit, a nie mockito.
*/

public class CalServiceTest {
	CalService calService;
	@org.junit.Before
	public void setup(){
		ICalculator cal = Mockito.mock(ICalculator.class);
		Mockito.when(cal.add(3,3)).thenReturn(6);
		calService = new CalService();
		calService.setCal(cal);
	}
	@org.junit.Test
	public void testAddTwoNumbers(){
		Assert.assertEquals(6, calService.addTwoNumbers(3,3));
	}
}
