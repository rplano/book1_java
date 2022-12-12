import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: 5. Condition
 * 
 * A simple ConsoleProgram that demonstrates the if statement.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Condition extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

	    int x = readInt("Enter a number: ");
	    if ( x > 5 ) {
	        println("Number is larger than 5.");
	    } else {
	        println("Number is less than or equal to 5.");
	    }
	}

}