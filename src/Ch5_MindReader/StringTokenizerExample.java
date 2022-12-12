import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: 2. StringTokenizerExample
 * 
 * Demonstrates the use of the StringTokenizer.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class StringTokenizerExample extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-20");
		
		String sentence = "hi there what's up?";
		StringTokenizer st = new StringTokenizer( sentence, " .,?" );
		while ( st.hasMoreTokens() ) {
			println( st.nextToken() );
		}
	}

}
