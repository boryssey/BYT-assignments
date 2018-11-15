package Model;
import Interfaces.Chain;

public class ChainNaN extends Chain{

	@Override
	public double calculate(CalcRequest req) {
		return Double.NaN;
	}

}
