import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: Temperature
 * 
 * A Console program that converts Fahrenheit to Celsius.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Temperature extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-24");

		int f = readInt("Enter temperature in Fahrenheit: ");
		int c = (int) (5.0 / 9.0) * (f - 32);
		println("Temperature in Celsius is: " + c);

	}

}
