import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: 4. LocalVariables
 * 
 * Draw a target using three ovals.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class LocalVariables extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-20");

		double feet = readDouble("Enter feet: ");
		feetToInches(feet);
		println(feet);
	}

	private void feetToInches(double feet) {
		feet = 42;
	}
}
