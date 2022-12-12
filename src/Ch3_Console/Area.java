import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: 4. Area
 * 
 * A simple ConsoleProgram that calculates the area of a circle.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Area extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		final double PI = 3.1415;
		println("Calculate the area of a circle.");
		double radius = readDouble("Enter radius: ");
		double area = PI * radius * radius;
		println("The area of the circle is: " + area);
	}

}
