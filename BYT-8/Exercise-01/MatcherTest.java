import org.junit.Assert;
import org.junit.Test;


public class MatcherTest {

	@Test
	public void testMatch() {
		Matcher matcher = new Matcher();

		int[] expected = new int[] { 10, 50, 30, 98 };
		int clipLimit = 100;
		int delta = 5;

		int[] actual = new int[] { 12, 55, 25, 110 };

		Assert.assertTrue(matcher.match(expected, actual, clipLimit, delta));

		actual = new int[] { 10, 60, 30, 98 };
		Assert.assertTrue(!matcher.match(expected, actual, clipLimit, delta));

		actual = new int[] { 10, 50, 30 };
		Assert.assertTrue(!matcher.match(expected, actual, clipLimit, delta));
	}
}
