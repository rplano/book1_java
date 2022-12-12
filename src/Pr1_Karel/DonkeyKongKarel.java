import stanford.karel.SuperKarel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: DonkeyKongKarel
 * 
 * Karel loves arcade games. This one is inspired by the famous Donkey Kong
 * game.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class DonkeyKongKarel extends SuperKarel {

	public void run() {
		for (int i = 0; i < 8; i++) {
			collectAllTreasureOnLevel();
			findNextLevel();
			moveUpAndBack();
		}
		collectAllTreasureOnLevel();
	}

	private void moveUpAndBack() {
		turnRight();
		move();
		turnLeft();
		while(frontIsClear()) {
			move();
		}
		turnAround();
	}

	private void findNextLevel() {
		turnAround();
		while (rightIsBlocked()) {
			if (frontIsClear()) {
				move();
			} else {
				turnAround();
			}
		}
	}

	private void collectAllTreasureOnLevel() {
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
}
