import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: 1. ReadFromFile
 * 
 * ConsoleProgram that reads data from a file.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class ReadFromFile extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		String fileName = readLine("Enter file to read: ");
		try {
			// open file
			FileReader fr = new FileReader(fileName);
			BufferedReader rd = new BufferedReader(fr);

			// read from file, line by line
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				println(line);
			}

			// close file
			rd.close();
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
