import stanford.karel.Karel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: 1. FirstKarel
 * 
 * Karel is supposed to pickup the beeper and move it to the end of the street.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class FirstKarel extends Karel {

	public void run() {
		move();
		move();
		pickBeeper();
		turnLeft();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		putBeeper();
	}
}
