import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.GLabel;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: 6a. MarsLander2
 * 
 * A simulation of landing on the mars.  Demonstrating inheritance.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class MarsLander2 extends GraphicsProgram {
	// constants
	private final int WIDTH = 300;
	private final int HEIGHT = 300;
	private final int DELAY = 100;
	private final int SPACE_SHIP_SIZE = 20;

	// instance variables
	private GSpaceShip spaceShip;
	private boolean isDead = false;

	public void run() {
		setup();
		waitForClick();

		// game loop
		while (spaceShip != null) {
			moveSpaceShip();
			checkForCollision();
			pause(DELAY);
		}
		displayGameOver();
	}

	private void moveSpaceShip() {
		spaceShip.move();
	}

	private void checkForCollision() {
		double y = spaceShip.getY();
		if (y > (getHeight() - SPACE_SHIP_SIZE)) {
			if (spaceShip.vy > 5) {
				isDead = true;
			}
			spaceShip = null;
		}
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 38: // up
			spaceShip.vy--;
			break;
		case 40: // down
			spaceShip.vy++;
			break;
		}
	}

	private void displayGameOver() {
		if (isDead) {
			displayGameOverMessage("You're dead!");
		} else {
			displayGameOverMessage("You survived!");
		}
	}

	private void displayGameOverMessage(String msg) {
		GLabel lbl = new GLabel(msg);
		lbl.setColor(Color.RED);
		lbl.setFont("SansSerif-bold-36");
		lbl.setLocation((getWidth() - lbl.getWidth()) / 2, getHeight() / 2);
		add(lbl);
	}

	private void setup() {
		setSize(WIDTH, HEIGHT);

		spaceShip = new GSpaceShip(SPACE_SHIP_SIZE);
		add(spaceShip, (getWidth() - SPACE_SHIP_SIZE) / 2, SPACE_SHIP_SIZE);

		addKeyListeners();
	}
}
