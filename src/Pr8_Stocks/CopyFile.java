import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: CopyFile
 * 
 * Copies a given text file to the file "copy.txt".
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class CopyFile extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		BufferedReader rd = openFileForReading();

		try {
			PrintWriter pw = new PrintWriter(new FileWriter("copy.txt"));

			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				println("Copying line[" + line + "]"); // write to console
				pw.println(line); // write to file
			}
			rd.close();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private BufferedReader openFileForReading() {
		BufferedReader rd = null;
		while (rd == null) {
			try {
				String name = readLine("Please enter filename: ");
				rd = new BufferedReader(new FileReader(name));
			} catch (IOException e) {
				println("bad file name");
			}
		}
		return rd;
	}
}
