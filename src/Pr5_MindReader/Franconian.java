import java.util.HashMap;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: Franconian
 * 
 * Translate from German to Franconian.
 * 
 * @see Dialekte in Bayern - Handreichung für den Unterricht,
 *      www.km.bayern.de/download/12707_broschuere_dialekt_2013_k.pdf
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Franconian extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		String german = readLine("Enter German text: ");
		String franconian = translateGermanToFraenkisch(german.toLowerCase());
		println(franconian);
	}

	private String translateGermanToFraenkisch(String german) {
		String franconian = "";
		for (int i = 0; i < german.length(); i++) {
			char c = german.charAt(i);
			franconian += translateChar(c);
		}
		return franconian;
	}

	private char translateChar(char c) {
		switch (c) {
		case 't':
			return 'd';
		case 'k':
			return 'g';
		case 'p':
			return 'b';
		default:
			return c;
		}
	}
}
