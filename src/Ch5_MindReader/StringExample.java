import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: 1. StringExample
 * 
 * Demonstrates the use of strings.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class StringExample extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-20");

		String s1 = "Hello";
		String s2 = "world";
		String s3 = "!";
		String s4 = " ";
		String s5 = "";

		String s6 = s1 + s4 + s2 + s3;
		println(s6);
	}

}
