import stanford.karel.SuperKarel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: YardstickKarel
 * 
 * Karel is supposed to measure the length of .
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class YardstickKarel extends SuperKarel {

	public void run() {
		measureLength();
	}

	private void measureLength() {
		putBeepersOnStick();
		moveToEnd();
		countBeepers();
		turnAround();
	}

	private void countBeepers() {
		moveToEndOfYardStick();
		while (beepersPresent()) {
			findLastBeeper();
			if (beepersPresent()) {
				moveBeeperToEnd();
			}
			moveToEndOfYardStick();
		}
	}

	private void moveBeeperToEnd() {
		pickBeeper();
		moveToEnd();
		putBeeper();
	}

	private void findLastBeeper() {
		while (beepersPresent()) {
			move();
		}
		turnAround();
		move();
	}

	private void moveToEndOfYardStick() {
		turnAround();
		while (leftIsClear()) {
			move();
		}
	}

	private void moveToEnd() {
		while (frontIsClear()) {
			move();
		}
	}

	private void putBeepersOnStick() {
		move();
		while (rightIsBlocked()) {
			putBeeper();
			move();
		}
	}
}
