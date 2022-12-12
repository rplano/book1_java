import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: TruthTables
 * 
 * A Console program that prints the truth tables for boolean operations &&, || and ^.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class TruthTables extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("monospaced-bold-20");

		println("|in1|in2|out|");
		for (int in1 = 0; in1 <= 1; in1++) {
			for (int in2 = 0; in2 <= 1; in2++) {
				boolean b1 = (in1 != 0);
				boolean b2 = (in2 != 0);
				boolean b3 = b1 ^ b2;
				if (b3) {
					println("| "+in1 + " | " + in2+" | 1 |");					
				} else {
					println("| "+in1 + " | " + in2+" | 0 |");					
				}
			}
		}
	}
}