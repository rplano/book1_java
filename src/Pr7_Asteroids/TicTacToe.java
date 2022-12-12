import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: TicTacToe
 * 
 * An implementation of the TicTacToe game.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class TicTacToe extends GraphicsProgram {
	private final int OFFSET = 47;
	private final int WIDTH = 600;
	private final int HEIGHT = 600 + OFFSET;
	private final int CELL_WIDTH = 200;

	private int currentPlayer = 1;

	public void run() {
		setup();
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int i = x / CELL_WIDTH;
		int j = y / CELL_WIDTH;

		if (TicTacToeLogic.isMoveAllowed(currentPlayer, i, j)) {
			displayPlayer(i, j, currentPlayer);
		}

		if (TicTacToeLogic.isGameOver()) {
			displayGameOver();
		}
	}

	private void displayGameOver() {
		GLabel lbl = new GLabel("Player " + currentPlayer + " lost!");
		lbl.setColor(Color.RED);
		lbl.setFont("SansSerif-72");
		lbl.setLocation((WIDTH - lbl.getWidth()) / 2, HEIGHT / 2);
		add(lbl);
	}

	private void displayPlayer(int i, int j, int player2) {
		if (currentPlayer == 1) {
			GImage img = new GImage("TicTacToe_X.png");
			add(img, i * CELL_WIDTH, j * CELL_WIDTH);
			currentPlayer = 2;
		} else {
			GImage img = new GImage("TicTacToe_O.png");
			add(img, i * CELL_WIDTH, j * CELL_WIDTH);
			currentPlayer = 1;
		}
	}

	private void setup() {
		setSize(WIDTH, HEIGHT);
		GImage background = new GImage("TicTacToe_background.png");
		add(background);
		addMouseListeners();
	}
}
