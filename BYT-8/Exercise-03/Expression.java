import java.util.HashMap;
import java.util.Map;

public class Expression {
	/*
	 * replaced switch with map.
	 * 
	 */

	private char op;

	private Expression left;

	private Expression right;

	private int constant;

	private Map<Character, Operation> opMap;

	{
		opMap = new HashMap<>();
		opMap.put('c', () -> constant);
		opMap.put('+', () -> left.evaluate() + right.evaluate());
		opMap.put('-', () -> left.evaluate() - right.evaluate());
		opMap.put('/', () -> left.evaluate() / right.evaluate());
		opMap.put('*', () -> left.evaluate() * right.evaluate());
	}

	public Expression(int constant) {
		this.op = 'c';
		this.constant = constant;
	}

	public Expression(char op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}

	public int evaluate() {
		if(!opMap.containsKey(op)) {
			throw new IllegalStateException();
		}

		return opMap.get(op).calc();
		
	}
}
