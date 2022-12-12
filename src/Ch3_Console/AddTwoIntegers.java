import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: 2. AddTwoIntegers
 * 
 * A simple ConsoleProgram that asks the user for two numbers, adds them and
 * returns the result.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class AddTwoIntegers extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");
		
		println("This program adds two numbers.");
		int n1 = readInt("Enter number one: ");
		int n2 = readInt("Enter number two: ");
		int sum = n1 + n2;
		println("The sum is: " + sum);
	}
}
