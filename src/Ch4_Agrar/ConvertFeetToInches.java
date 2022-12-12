import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: 3. ConvertFeetToInches
 * 
 * Draw a target using three ovals.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class ConvertFeetToInches extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		double feet = readDouble("Enter feet: ");
		double inches = feetToInches(feet);
		println(feet + " feet are " + inches + " inches.");
	}

	private double feetToInches(double feet) {
		double inches = 12 * feet;
		return inches;
	}
}
