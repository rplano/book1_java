/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: GeometryRun
 * 
 * A jump-and-run game where you try to escape incoming geometric objects.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public interface GeometryConstants {
	public final int APP_WIDTH = 400;
	public final int APP_HEIGHT = 200;
	public final int GRAVITY = 2;
	public final int DELAY = 50;

	public final int NR_OF_OBSTACLES = 3;
	public final int OBSTACLES_SIZE = 40;
	public final int OBSTACLES_SPEED = 5;

	public final int DASH_SIZE = 30;
	public final int DASH_JUMP = 20;
	public final int DASH_X_POS = APP_WIDTH / 2;
	public final int DASH_Y_POS = APP_HEIGHT - 2 * OBSTACLES_SIZE;

}
