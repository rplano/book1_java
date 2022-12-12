import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: GameOfLife
 * 
 * Conway's Game of Life en.wikipedia.org/wiki/Conway's_Game_of_Life
 * 
 * The universe of the Game of Life is an infinite two-dimensional orthogonal
 * grid of square cells, each of which is in one of two possible states, alive
 * or dead. Every cell interacts with its eight neighbours, which are the cells
 * that are horizontally, vertically, or diagonally adjacent.
 * 
 * At each step in time, the following transitions occur: <br/>
 * - Any live cell with fewer than two live neighbours dies, as if caused by
 * under-population. <br/>
 * - Any live cell with two or three live neighbours lives on to the next
 * generation. <br/>
 * - Any live cell with more than three live neighbours dies, as if by
 * overcrowding. <br/>
 * - Any dead cell with exactly three live neighbours becomes a live cell, as if
 * by reproduction. <br/>
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class GameOfLife extends GraphicsProgram {
	private static final int SIZE = 100;
	private static final int CELL_SIZE_IN_PIXEL = 4;
	private static final int DELAY = 100;
	private static final double LIFE_PROBABILITY = 0.5;

	private boolean[][] cells = new boolean[SIZE][SIZE];
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void init() {
		setSize(SIZE * CELL_SIZE_IN_PIXEL, SIZE * CELL_SIZE_IN_PIXEL);
		for (int i = 0; i < SIZE * SIZE * LIFE_PROBABILITY; i++) {
			cells[rgen.nextInt(0, SIZE - 1)][rgen.nextInt(0, SIZE - 1)] = true;
		}
	}

	public void run() {
		// game loop
		while (true) {
			displayCells();
			transitions();
			pause(DELAY);
		}
	}

	private void transitions() {
		boolean[][] temp = new boolean[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				int nrOfNeighbors = countNeighbors(i, j);
				if (cells[i][j]) {
					// Any live cell with fewer than two live neighbours dies,
					// as if caused by under-population.

					// Any live cell with two or three live neighbours lives on
					// to the next generation.
					if ((nrOfNeighbors == 2) || (nrOfNeighbors == 3)) {
						temp[i][j] = true;
					}
					// Any live cell with more than three live neighbours dies,
					// as if by overcrowding.

				} else {
					// Any dead cell with exactly three live neighbours becomes
					// a live cell, as if by reproduction.
					if (nrOfNeighbors == 3) {
						temp[i][j] = true;
					}
				}
			}
		}
		cells = temp;
	}

	private int countNeighbors(int i, int j) {
		int counter = 0;
		if (testCell(i - 1, j - 1))
			counter++;
		if (testCell(i - 1, j))
			counter++;
		if (testCell(i - 1, j + 1))
			counter++;
		if (testCell(i, j - 1))
			counter++;
		if (testCell(i, j + 1))
			counter++;
		if (testCell(i + 1, j - 1))
			counter++;
		if (testCell(i + 1, j))
			counter++;
		if (testCell(i + 1, j + 1))
			counter++;
		return counter;
	}

	// truncates at borders
	private boolean testCell1(int i, int j) {
		if (i >= 0 && i <= SIZE - 1) {
			if (j >= 0 && j <= SIZE - 1) {
				return cells[i][j];
			}
		}
		return false;
	}

	// loops around at borders
	private boolean testCell(int i, int j) {
		return cells[(i + SIZE) % SIZE][(j + SIZE) % SIZE];
	}

	private void displayCells() {
		removeAll();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (cells[i][j]) {
					GRect r = new GRect(CELL_SIZE_IN_PIXEL * i,
							CELL_SIZE_IN_PIXEL * j, CELL_SIZE_IN_PIXEL,
							CELL_SIZE_IN_PIXEL);
					r.setFilled(true);
					add(r);
				}
			}
		}
	}
}
