import stanford.karel.SuperKarel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: WritingKarel
 * 
 * Karel writes the first letter of his name 'K'.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class WritingKarel extends SuperKarel {

	public void run() {
		moveToStart();
		drawMainLine();
		moveToMiddle();
		drawUpperDiagonal();
		moveDown();
		drawLowerDiagonal();
		moveToBeginning();
	}

	private void moveToBeginning() {
		moveToWall();
		turnLeft();
		moveToWall();
		turnLeft();
	}

	private void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}

	private void drawLowerDiagonal() {
		for (int i = 0; i < 3; i++) {
			putBeeper();
			move();
			turnRight();
			move();
			turnLeft();
		}
	}

	private void moveDown() {
		turnRight();
		for (int i = 0; i < 7; i++) {
			move();
		}
		turnRight();
		move();
	}

	private void drawUpperDiagonal() {
		for (int i = 0; i < 4; i++) {
			putBeeper();
			move();
			turnLeft();
			move();
			turnRight();
		}
	}

	private void moveToMiddle() {
		turnAround();
		for (int i = 0; i < 4; i++) {
			move();
		}
		turnLeft();
		move();
	}

	private void drawMainLine() {
		for (int i = 0; i < 7; i++) {
			putBeeper();
			move();
		}
	}

	private void moveToStart() {
		move();
		move();
		move();
		turnLeft();
		move();
	}
}