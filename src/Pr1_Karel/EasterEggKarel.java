import stanford.karel.SuperKarel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: EasterEggKarel
 * 
 * Karel is looking for easter eggs.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class EasterEggKarel extends SuperKarel {

	public void run() {
		findEasterEggs();
	}

	private void findEasterEggs() {
		findEggsInOneRow();
		moveBack();
		while (frontIsClear()) {
			moveToNextRow();
			findEggsInOneRow();
			moveBack();
		}
	}

	private void findEggsInOneRow() {
		while (frontIsClear()) {
			if (beepersPresent()) {
				pickBeeper();
			}
			move();
		}
		if (beepersPresent()) {
			pickBeeper();
		}
	}

	private void moveBack() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnRight();
	}

	private void moveToNextRow() {
		move();
		turnRight();
	}
}