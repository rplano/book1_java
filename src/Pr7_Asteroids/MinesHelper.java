/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: MinesHelper
 * 
 * MinesHelper: a helper class for MinesClone that given a field with mines,
 * counts all the mines.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class MinesHelper implements MinesConstant {

	/**
	 * It is advantageous to keep a reference to the field, otherwise we would
	 * have to pass it to the countMinesSurroundingTile() method every time.
	 */
	private static char[][] field;

	/**
	 * This method goes through all tiles of a given field and counts the mines
	 * surrounding the given tile. If the tile is a mine, no counting needs to
	 * be done. <br>
	 * Pre-condition: the field f has only the chars 'M' and ' ' (space) in it. <br>
	 * Post-condition: the field f now has the chars 'M' (mine) or ' ' (no mines
	 * neighboring), '1' (one mine neighboring), '2' (two mines neighboring),
	 * etc.
	 * 
	 * @param f
	 *            a 2D field of chars.
	 */
	public static void countMines(char[][] f) {
		field = f;
		for (int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j < FIELD_SIZE; j++) {
				if (field[i][j] != 'M') {
					int nrOfMines = countMinesSurroundingTile(i, j);
					field[i][j] = (char) ('0' + nrOfMines);
				}
			}
		}
	}

	/**
	 * Counts the mines surrounding a given tile.
	 * 
	 * @param x
	 *            the x position of the tile.
	 * @param y
	 *            the y position of the tile.
	 * @return the number of mines surrounding the given tile.
	 */
	private static int countMinesSurroundingTile(int x, int y) {
		int nrOfMines = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if ((x + i >= 0) && (x + i < FIELD_SIZE)) {
					if ((y + j >= 0) && (y + j < FIELD_SIZE)) {
						if (field[x + i][y + j] == 'M')
							nrOfMines++;
					}
				}
			}
		}
		return nrOfMines;
	}
}
