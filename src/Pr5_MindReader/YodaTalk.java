import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: YodaTalk
 * 
 * This is a translator from English to Yodish.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class YodaTalk extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		String english = readLine("Enter English text: ");
		String yodish = translateFromEnglishToYodish(english);
		println(yodish);
	}

	private String translateFromEnglishToYodish(String english) {
		StringTokenizer st = new StringTokenizer(english);
		String s = st.nextToken();
		String v = st.nextToken();
		String p = st.nextToken();
		String yodish = p + ", " + s + " " + v;
		return yodish;
	}

}
