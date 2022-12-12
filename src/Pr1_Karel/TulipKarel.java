import stanford.karel.SuperKarel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: TulipKarel
 * 
 * Karel plants some tulips.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class TulipKarel extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			move();
			if (rightIsClear()) {
				plantTulip();
			}
		}
	}

	private void plantTulip() {
		turnRight();
		move();
		putBeeper();
		turnAround();
		move();
		turnRight();
	}
}