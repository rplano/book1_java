import stanford.karel.SuperKarel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: PartyKarel
 * 
 * Karel has to clean up his place after a party.  
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class PartyKarel  extends SuperKarel {

	public void run() {
		while(leftIsClear()) {
			clearOneRow();
			moveBack();
			moveToNext();
		}
		clearOneRow();
	}

	private void clearOneRow() {
		while (frontIsClear()) {
			if(beepersPresent()) {
				pickBeeper();
			}
			move();
		}
		if(beepersPresent()) {
			pickBeeper();
		}
	}

	private void moveBack() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
	}

	private void moveToNext() {
		turnRight();
		if (frontIsClear()) {
			move();
		}
		turnRight();		
	}
}