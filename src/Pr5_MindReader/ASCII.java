import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: ASCII
 * 
 * Print ASCII characters from 32 to 128.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class ASCII extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("monospaced-18");

		isUpperCase('a');
		toUpperCase('a');
		printASCIITable();
	}

	private char toUpperCase(char klein) {
		int gross = klein - 'a' + 'A';
		return (char) gross;
	}

	private boolean isUpperCase(char c) {
		if (c >= 'A' && c <= 'Z') {
			return true;
		} else {
			return false;
		}
	}

	private void printASCIITable() {
		for (int i = 32; i < 128; i++) {
			if (i % 32 == 0)
				println();

			print((char) i);
		}
	}

}
