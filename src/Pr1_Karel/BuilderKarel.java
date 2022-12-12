import stanford.karel.SuperKarel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: BuilderKarel
 * 
 * Karel's house was hit by a tornado. He has to fix it!
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class BuilderKarel extends SuperKarel {

	public void run() {
		move();
		move();
		for (int i = 0; i < 2; i++) {
			fixColumn();
			moveToNextColumn();
		}
		fixColumn();
	}

	private void fixColumn() {
		moveUpAndFix();
		moveDown();
	}

	private void moveDown() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}

	private void moveUpAndFix() {
		turnLeft();
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
			}
			move();
		}
		if (noBeepersPresent()) {
			putBeeper();
		}
	}

	private void moveToNextColumn() {
		move();
		move();
		move();
	}
}
