import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: ReadOneChar
 * 
 * Reads one and exactly one character.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class ReadOneChar extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		char c = readOneChar();
		println("You entered: " + c);
	}

	private char readOneChar() {
		String s;
		while (true) {
			s = readLine();
			if (s.length() == 1)
				break;
			println("You idiot, you must enter only one character:");
		}
		char c = s.charAt(0);
		return c;
	}

}
