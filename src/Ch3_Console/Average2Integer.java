import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: 3. Average2Integer
 * 
 * A simple ConsoleProgram that should calculate the average of two integers.
 * Could you modify it such that it averages an arbitrary number of positive
 * integers? (sentinel)
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Average2Integer extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		int n1 = readInt("Enter first number:");
		int n2 = readInt("Enter second number:");
		//int average = n1 + n2 / 2;
		//int average = (n1 + n2) / 2;
		//double average = (n1 + n2) / 2;
		double average = (n1 + n2) / 2.0;
		println("The average is: " + average);
	}
}
