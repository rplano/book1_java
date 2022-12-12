/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: Point
 * 
 * This class represents a point in 2D space having x and y coordinate.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Point {
	private int x = 0;
	private int y = 0;

	public Point() {
		this(0, 0);
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public boolean equals(Point p) {
		if (this.x == p.x && this.y == p.y) {
			return true;
		}
		return false;
	}

	public void add(Point p) {
		this.x += p.x;
		this.y += p.y;
	}

	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}