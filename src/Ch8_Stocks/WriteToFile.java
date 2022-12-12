import java.io.FileWriter;
import java.io.IOException;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: 2. WriteToFile
 * 
 * ConsoleProgram that writes data to a file.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class WriteToFile extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		try {
			// open file
			FileWriter fw = new FileWriter("test.txt", false);

			// write to file, one string at a time
			println("Enter text to write ('.' to quit): ");
			while (true) {
				String line = readLine("");
				if (line.equals("."))
					break;
				fw.write(line + "\n");
			}

			// close file
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	};
}
