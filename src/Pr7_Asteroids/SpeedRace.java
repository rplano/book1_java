import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: SpeedRace
 * 
 * A GraphicsProgram based on the arcade classic SpeedRace.
 * 
 * @see https://en.wikipedia.org/wiki/Tomohiro_Nishikado#Speed_Race
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class SpeedRace extends GraphicsProgram {
	private final int SIZE = 300;
	private final int OFFSET = 46;

	private final int DELAY = 50;

	private final int NR_OF_CARS = 5;
	private final int CAR_SPEED = 5;
	private final int CAR_HEIGHT = 40;
	private final int CAR_WIDTH = 20;

	private final int NR_OF_LANES = 5;
	private final int LANE_LENGTH = SIZE / ((NR_OF_LANES - 1) * 2);
	private final int LANE_WIDTH = 10;

	private RandomGenerator rgen = new RandomGenerator();

	private GRect car;
	private GRect[] otherCars;
	private GRect[] middleLane;

	public void run() {
		setup();
		waitForClick();

		while (true) {
			moveRoad();
			moveCars();
			checkForCollisionCarsWithWall();
			pause(DELAY);
		}
	}

	private void checkForCollisionCarsWithWall() {
		for (int i = 0; i < NR_OF_CARS; i++) {
			if (otherCars[i].getY() > SIZE) {
				int x = (SIZE - CAR_WIDTH) / 2 + rgen.nextInt(-5, 5)
						* CAR_WIDTH;
				int y = rgen.nextInt(-10, 0) * CAR_HEIGHT;
				otherCars[i].setLocation(x, y);
			}
		}
	}

	private void moveCars() {
		for (int i = 0; i < NR_OF_CARS; i++) {
			otherCars[i].move(0, CAR_SPEED);
		}
	}

	private void moveRoad() {
		for (int i = 0; i < NR_OF_LANES; i++) {
			middleLane[i].move(0, CAR_SPEED);
			double x = middleLane[i].getX();
			double y = middleLane[i].getY() + LANE_LENGTH;
			middleLane[i].setLocation(x, y % SIZE - LANE_LENGTH);
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case 37:
			car.move(-5, 0);
			break;
		case 39:
			car.move(5, 0);
			break;
		default:
			// println(key);
			break;
		}
	}

	private void setup() {
		setSize(SIZE, SIZE);
		setBackground(Color.BLACK);

		// draw road
		GRect leftRoad = new GRect(50, SIZE);
		leftRoad.setFilled(true);
		leftRoad.setFillColor(Color.LIGHT_GRAY);
		add(leftRoad, 0, 0);
		GRect rightRoad = new GRect(50, SIZE);
		rightRoad.setFilled(true);
		rightRoad.setFillColor(Color.LIGHT_GRAY);
		add(rightRoad, 200 + 50, 0);

		// draw middle lane
		middleLane = new GRect[NR_OF_LANES];
		for (int i = 0; i < NR_OF_LANES; i++) {
			middleLane[i] = new GRect(LANE_WIDTH, LANE_LENGTH);
			middleLane[i].setFilled(true);
			middleLane[i].setFillColor(Color.WHITE);
			add(middleLane[i], (SIZE - LANE_WIDTH) / 2, (i - 1) * 2
					* LANE_LENGTH);
		}

		// create other cars
		otherCars = new GRect[NR_OF_CARS];
		for (int i = 0; i < NR_OF_CARS; i++) {
			otherCars[i] = new GRect(CAR_WIDTH, CAR_HEIGHT);
			otherCars[i].setFilled(true);
			otherCars[i].setFillColor(rgen.nextColor());
			int x = (SIZE - CAR_WIDTH) / 2 + rgen.nextInt(-5, 5) * CAR_WIDTH;
			int y = rgen.nextInt(-10, 0) * CAR_HEIGHT;
			add(otherCars[i], x, y);
		}

		// create my car
		car = new GRect(CAR_WIDTH, CAR_HEIGHT);
		car.setFilled(true);
		car.setFillColor(Color.RED);
		add(car, (SIZE - CAR_WIDTH) / 2, SIZE - 50 - OFFSET);

		addKeyListeners();
	}
}
