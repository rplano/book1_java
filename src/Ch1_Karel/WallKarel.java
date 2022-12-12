import stanford.karel.Karel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: 4. WallKarel
 * 
 * Karel is supposed to walk to the wall.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class WallKarel extends Karel {

	public void run() {
		moveToWall();
	}

	private void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
	

}





