import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: Agrar
 * 
 * The objective of the game is to grow a cell by swallowing pellets.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Agrar extends GraphicsProgram {

	/** Width and height of application window in pixels */
	private final int WIDTH = 600;
	private final int HEIGHT = 600;

	private final int DELAY = 20;
	private final int MOUSE_MOVE_SPEED = 10;

	/** Radius of the ball in pixels */
	private final int BALL_RADIUS = 20;
	private final int FOOD_RADIUS = 10;

	private GImage backgroundImage;
	private final String BACKGROUND_IMAGE_NAME = "background_grid.png";

	private RandomGenerator rgen;

	private GOval cell;
	private int xMouse = 0;
	private int yMouse = 0;

	/** Runs the Agar.io program. */
	public void run() {
		setup();

		while (true) { // game loop
			moveCell();
			createRandomFood();
			checkForCollision();
			pause(DELAY);
		}

	}

	private void checkForCollision() {
		double w = cell.getWidth();
		double h = cell.getHeight();
		for (double x = cell.getX(); x < cell.getX() + w; x += FOOD_RADIUS) {
			for (double y = cell.getY(); y < cell.getY() + h; y += FOOD_RADIUS) {
				GObject collisonObject = getElementAt(x, y);
				if ((collisonObject != null) && (collisonObject != cell)
						&& (collisonObject != backgroundImage)) {
					cell.setSize(w + 1, h + 1);
					remove(collisonObject);
					collisonObject = null;
				}
			}
		}
	}

	private void createRandomFood() {
		if (rgen.nextInt(10) < 1) { // only do it 10 percent of the time
			GOval food = new GOval(FOOD_RADIUS, FOOD_RADIUS);
			food.setFilled(true);
			food.setFillColor(rgen.nextColor());
			this.add(food, rgen.nextInt(3 * WIDTH) - WIDTH,
					rgen.nextInt(HEIGHT));
		}
	}

	private void moveCell() {
		// get distance between mouse and ball
		double dx = xMouse - cell.getX() - cell.getWidth() / 2;
		double dy = yMouse - cell.getY() - cell.getHeight() / 2;
		// scale
		dx /= MOUSE_MOVE_SPEED;
		dy /= MOUSE_MOVE_SPEED;
		// move ball
		cell.move(dx, dy);
	}

	public void mouseMoved(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
	}

	private void setup() {
		// set size of display
		this.setSize(WIDTH, HEIGHT);

		// setup random generator
		rgen = RandomGenerator.getInstance();

		// add a big background image
		backgroundImage = new GImage(BACKGROUND_IMAGE_NAME);
		backgroundImage.scale(3);
		this.add(backgroundImage);

		// create and add ball
		cell = new GOval(BALL_RADIUS, BALL_RADIUS);
		cell.setFilled(true);
		cell.setFillColor(Color.RED);
		this.add(cell, WIDTH / 2, HEIGHT / 2);

		addMouseListeners();
	}
}
