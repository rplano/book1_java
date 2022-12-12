import stanford.karel.SuperKarel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: PyramidKarel
 * 
 * Karel is supposed to build a pyramid.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class PyramidKarel extends SuperKarel {

	public void run() {
		putFirstLineOfBeepers();
		putSecondLineOfBeepers();
		while (beepersPresent()) {
			putNthLineOfBeepers();
			move();
		}
	}

	private void putNthLineOfBeepers() {
		move();
		while (beepersPresent()) {
			putOneBeeperAbove();
		}
		removeLastBeeper();
		moveBack();
	}

	private void moveBack() {
		move();
		while (beepersPresent()) {
			move();
		}
		turnAround();
	}

	private void removeLastBeeper() {
		turnLeft();
		move();
		turnLeft();
		move();
		if (beepersPresent()) {
			pickBeeper();
		}
	}

	private void putOneBeeperAbove() {
		turnLeft();
		move();
		putBeeper();
		turnRight();
		move();
		turnRight();
		move();
		turnLeft();
	}

	private void putSecondLineOfBeepers() {
		turnLeft();
		move();
		turnLeft();
		move();
		putFirstLineOfBeepers();
		pickBeeper();
		turnAround();
		move();
	}

	private void putFirstLineOfBeepers() {
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper();
	}

}
