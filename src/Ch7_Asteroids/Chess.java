import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: 3. Chess
 * 
 * A simple console program shows how to use two dimensional arrays.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Chess extends ConsoleProgram {

	private char[][] chess = { { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
			{ 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
			{ 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' } };

	public void run() {
		setSize(400, 400);
		setFont("Courier-bold-32");

		printChessBoard();
	}

	private void printChessBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				print(chess[i][j]);
			}
			println();
		}
	}
}
