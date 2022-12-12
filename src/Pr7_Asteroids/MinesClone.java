import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.io.IODialog;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: MinesClone
 * 
 * MinesClone: randomly distribute 10 mines over an 8x8 playing field. Use
 * checkForMinesAt(x,y) to check for mines. It returns a char with the digit
 * ' ', '1', ... or 'M'. Start a timer at the beginning of the game. Use
 * JOptionPane to give user feedback how long it took. Challenge: play the real
 * game of mines, you will notice when you click on an empty field the
 * surrounding tiles will be uncovered.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class MinesClone extends GraphicsProgram implements MinesConstant {

	/** Playing field is represented by an 8x8 array of chars */
	private char[][] field = new char[FIELD_SIZE][FIELD_SIZE];

	/** Runs the MinesClone program. */
	public void run() {
		setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		initialzeField();
		MinesHelper.countMines(field);
		drawInitialField();
		addMouseListeners();
	}

	/**
	 * Initialize the whole field with NUMBER_OF_MINES being randomly
	 * distributed.
	 */
	private void initialzeField() {
		RandomGenerator rgen = RandomGenerator.getInstance();
		for (int i = 0; i < NUMBER_OF_MINES; i++) {
			int x = rgen.nextInt(0, FIELD_SIZE - 1);
			int y = rgen.nextInt(0, FIELD_SIZE - 1);
			field[x][y] = 'M';
		}
	}

	/**
	 * Draws the whole field, showing all the information.
	 */
	private void drawWholeField() {
		for (int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j < FIELD_SIZE; j++) {
				drawOneTile(i, j);
			}
		}
	}

	/**
	 * Draws at the position i,j an image of a mine ("mine.png"), if there is
	 * one or the empty field image ("empty.png") overlayed with a GLabel
	 * displaying the number of neighboring mines.
	 */
	private void drawOneTile(int i, int j) {
		GImage img;
		switch (field[i][j]) {
		case 'M':
			img = new GImage("mine.png");
			add(img, i * PIXEL_PER_TILE, j * PIXEL_PER_TILE);
			break;
		case '0':
			img = new GImage("empty.png");
			add(img, i * PIXEL_PER_TILE, j * PIXEL_PER_TILE);
			break;
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
			img = new GImage("empty.png");
			add(img, i * PIXEL_PER_TILE, j * PIXEL_PER_TILE);
			addLabelToTile(i, j, field[i][j], LABEL_COLORS[field[i][j] - '1']);
			break;
		default:
			img = new GImage("initial.png");
			add(img, i * PIXEL_PER_TILE, j * PIXEL_PER_TILE);
		}
	}

	private void addLabelToTile(int i, int j, char nr, Color col) {
		GLabel nrLbl = new GLabel("" + nr);
		nrLbl.setColor(col);
		nrLbl.setFont("SansSerif-32");
		add(nrLbl, i * PIXEL_PER_TILE + 15, j * PIXEL_PER_TILE + 35);
	}

	/**
	 * Draws the initial field, with all fields showing the "initial.png" image.
	 */
	private void drawInitialField() {
		for (int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j < FIELD_SIZE; j++) {
				GImage img = new GImage("initial.png");
				add(img, i * PIXEL_PER_TILE, j * PIXEL_PER_TILE);
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX() / PIXEL_PER_TILE;
		int y = e.getY() / PIXEL_PER_TILE;
		if (e.getButton() == MouseEvent.BUTTON3) {
			GImage img = new GImage("marked.png");
			add(img, x * PIXEL_PER_TILE, y * PIXEL_PER_TILE);
		} else {
			GObject obj = getElementAt(x * PIXEL_PER_TILE, y * PIXEL_PER_TILE);
			remove(obj);
			if (field[x][y] == 'M') {
				drawWholeField();
				GImage img = new GImage("exploded.png");
				add(img, x * PIXEL_PER_TILE, y * PIXEL_PER_TILE);

				IODialog dia = getDialog();
				dia.println("You lost!");
			} else if (field[x][y] == '0') {
				println("gr");
				// drawOneTile(x, y);
				discoverEmtpyTiles(x, y);
			} else {
				drawOneTile(x, y);
			}
		}
	}

	private void discoverEmtpyTiles(int x, int y) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if ((x + i >= 0) && (x + i < FIELD_SIZE)) {
					if ((y + j >= 0) && (y + j < FIELD_SIZE)) {
						drawOneTile(x + i, y + j);
						if (field[x + i][y + j] == '0') {
							// if ( (i!=0) && (j!=0) ) {
							// discoverEmtpyTiles(x,y);
							// }
						}
					}
				}
			}
		}
	}

	/**
	 * Optional: when mouse is pressed show the "initial_pressed.png" image
	 */
	public void mousePressed(MouseEvent e) {
		int x = e.getX() / PIXEL_PER_TILE;
		int y = e.getY() / PIXEL_PER_TILE;
		GObject obj = getElementAt(x * PIXEL_PER_TILE, y * PIXEL_PER_TILE);
		remove(obj);
		GImage img = new GImage("initial_pressed.png");
		add(img, x * PIXEL_PER_TILE, y * PIXEL_PER_TILE);
	}

	/**
	 * Optional: when mouse is releases show again the "initial.png" image
	 */
	public void mouseReleased(MouseEvent e) {
		int x = e.getX() / PIXEL_PER_TILE;
		int y = e.getY() / PIXEL_PER_TILE;
		GObject obj = getElementAt(x * PIXEL_PER_TILE, y * PIXEL_PER_TILE);
		remove(obj);
		GImage img = new GImage("initial.png");
		add(img, x * PIXEL_PER_TILE, y * PIXEL_PER_TILE);
	}

	public static void main(String[] args) {
		new MinesClone().start(args);
	}
}
