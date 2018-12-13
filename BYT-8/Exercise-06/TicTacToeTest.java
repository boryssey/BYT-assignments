import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTest {


	@Test
	public void testDefaultMove() {
		TicTacToe game = new TicTacToe("XOXOX-OXO");
		Assert.assertEquals(5, game.suggestMove('X'));

		game = new TicTacToe("XOXOXOOX-");
		Assert.assertEquals(8, game.suggestMove('O'));

		game = new TicTacToe("---------");
		Assert.assertEquals(0, game.suggestMove('X'));

		game = new TicTacToe("XXXXXXXXX");
		Assert.assertEquals(-1, game.suggestMove('X'));
	}
	@Test
	public void testFindWinningMove() {
		TicTacToe game = new TicTacToe("XO-XX-OO-");
		Assert.assertEquals(5, game.suggestMove('X'));
		Assert.assertEquals(8, game.suggestMove('O'));
	}
	@Test
	public void testWinConditions() {
		assertWinner("---XXX---", 'X');
		assertWinner("XXX------", 'X');
		assertWinner("------XXX", 'X');
		assertWinner("X--X--X--", 'X');
		assertWinner("-X--X--X-", 'X');
		assertWinner("--X--X--X", 'X');
		assertWinner("X---X---X", 'X');
		assertWinner("--X-X-X--", 'X');
		
		assertWinner("---OOO---", 'O');
		assertWinner("OOO------", 'O');
		assertWinner("------OOO", 'O');
		assertWinner("O--O--O--", 'O');
		assertWinner("-O--O--O-", 'O');
		assertWinner("--O--O--O", 'O');
		assertWinner("O---O---O", 'O');
		assertWinner("--O-O-O--", 'O');

		assertWinner("---------", '-');
		assertWinner("XXOOOXXOO", '-');
	}

	private void assertWinner(String s, char w) {
		TicTacToe game = new TicTacToe(s);
		Assert.assertEquals(w, game.winner());		
	}
}