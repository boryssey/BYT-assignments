package UnitTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Interfaces.Chain;
import Model.CalcRequest;
import Model.ChainAdd;
import Model.ChainDiv;
import Model.ChainMul;
import Model.ChainNaN;
import Model.ChainSub;

public class ChainTest {
	Chain first; // addition

	@Before
	public void before() {
		first = new ChainAdd();
		Chain div = new ChainDiv();
		Chain mul = new ChainMul();
		Chain sub = new ChainSub();
		Chain nan = new ChainNaN();
		first.setNextChain(div).setNextChain(mul).setNextChain(sub).setNextChain(nan);
	}

	@Test
	public void testAdd() {
		Assert.assertEquals(999, first.calculate(new CalcRequest("+", 555, 444)), 0.0);
		Assert.assertEquals(12, first.calculate(new CalcRequest("+", 11, 1)), 0.0);
	}

	@Test
	public void testDiv() {
		Assert.assertEquals(3, first.calculate(new CalcRequest("/", 6, 2)), 0.0);
	}

	@Test
	public void testMul() {
		Assert.assertEquals(66, first.calculate(new CalcRequest("*", 22, 3)), 0.0);
	}

	@Test
	public void testSub() {
		Assert.assertEquals(25, first.calculate(new CalcRequest("-", 30, 5)), 0.0);
	}

	@Test
	public void testNan() {
		Assert.assertEquals(Double.NaN, first.calculate(new CalcRequest("=", 12, 12)), 0.0);
	}

}
