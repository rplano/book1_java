import stanford.karel.Karel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: 6. RobinHoodKarel
 * 
 * Karel takes from the rich and gives to the poor.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class RobinHoodKarel extends Karel {

	public void run() {
		while (frontIsClear()) {
			if (beepersPresent()) {
				pickBeeper();
			} else {
				putBeeper();
			}
			move();
		}
		
		if (beepersPresent()) {
			pickBeeper();
		} else {
			putBeeper();
		}
	}
}
