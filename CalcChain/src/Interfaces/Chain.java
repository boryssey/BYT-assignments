package Interfaces;
import Model.CalcRequest;

public abstract class Chain {
	public Chain nextChain;

	public abstract double calculate(CalcRequest req);

	public Chain setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
		return nextChain;
	}
}
