
import java.io.FileWriter;
import java.io.PrintWriter;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: Minutes
 * 
 * A program that can be used to take minutes of a meeting. The minutes are
 * stored in the file "minutes.txt".
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Minutes extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		println("Welcome to Minutes!");
		println("(to quit hit enter)");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter("minutes.txt"));
			while (true) {
				String line = readLine(":");
				if (line.equals(""))
					break;
				pw.println(line);
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
