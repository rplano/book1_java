import stanford.karel.SuperKarel;


/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: BreadcrumbKarel
 * 
 * You want Karel to follow the breadcrumbs.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class BreadcrumbKarel extends SuperKarel {

	public void run() {
		move();
		while (beepersPresent()) {
			pickBeeper();
			moveToNextBeeper();
		}
	}

	private void moveToNextBeeper() {
		checkLeft();
		if (noBeepersPresent()) {
			checkStraight();
		}
		if (noBeepersPresent()) {
			checkRight();
		}
	}

	private void checkLeft() {
		turnLeft();
		move();
		if (noBeepersPresent()) {
			turnAround();
			move();
			turnLeft();
		}
	}

	private void checkStraight() {
		move();
		if (noBeepersPresent()) {
			turnAround();
			move();
			turnAround();
		}
	}

	private void checkRight() {
		turnRight();
		move();
		if (noBeepersPresent()) {
			turnAround();
			move();
			turnRight();
		}
	}
}