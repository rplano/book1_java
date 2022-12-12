import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: 3. Immutability
 * 
 * Demonstrates the strings are immutable.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Immutability extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-20");

		String s1 = "Hello";
		s1.toUpperCase();
		println(s1);

		s1 = s1.toUpperCase();
		println(s1);

		s1 = "Hello ";
		String s2 = s1 + "world";
		String s3 = "Hello world";
		if (s2.equals(s3)) {
			println("Equal");
		} else {
			println("Not Equal");
		}

		s1 = "Hello world";
		int posSpace = s1.indexOf(' ');
		s2 = s1.substring(0, posSpace);
		s3 = s1.substring(posSpace);
		println(s2);
		println(s3);
	}

}
