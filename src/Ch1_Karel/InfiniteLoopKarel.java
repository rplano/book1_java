import stanford.karel.Karel;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Karel: 5. InfiniteLoopKarel
 * 
 * Karel is stuck in an infinite loop.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class InfiniteLoopKarel extends Karel {

	public void run() {
		while (frontIsClear()) {
			turnLeft();
		}
	}
}
