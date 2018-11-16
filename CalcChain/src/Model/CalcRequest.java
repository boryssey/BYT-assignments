package Model;

public class CalcRequest {
	public String operation;
	public double num1;
	public double num2;
	
	public CalcRequest(String op, double number1, double number2) {
		operation = op;
		num1 = number1;
		num2 = number2;
	}
}
