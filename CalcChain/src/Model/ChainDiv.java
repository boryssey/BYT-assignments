package Model;
import Interfaces.Chain;

public class ChainDiv extends Chain{

	@Override
	public double calculate(CalcRequest req) {
		if(req.operation.equals("/")) {
			return req.num1/req.num2;
		}
		return nextChain.calculate(req);
	}

}
