public class Matcher {
	public Matcher() {
	}

	/*
	 * Moved "Check that each entry within expected +/- delta" to the same loop as
	 * "Check for length differences" ifs didn't have brackets, so added them. Moved
	 * "Check for length differences" at the top, it doesn't make sense to check it
	 * at the end.
	 */

	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {
		if (actual.length != expected.length) {
			return false;
		}

		for (int i = 0; i < actual.length; i++) {
			if (actual[i] > clipLimit) {
				actual[i] = clipLimit;
			}
			if (Math.abs(expected[i] - actual[i]) > delta) {
				return false;
			}
		}

		return true;
	}
}