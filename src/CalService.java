/**
 * Created by Torak28 on 24.01.2017.
 */
public class CalService {
	ICalculator cal;
	public int addTwoNumbers(int x, int y){
		return cal.add(x,y);
	}
	public ICalculator getCal(){
		return cal;
	}
	public void setCal(ICalculator cal) {
		this.cal = cal;
	}
}
