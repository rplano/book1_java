import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: StateLookup
 * 
 * Does a lookup for US states, e.g. a search for NY returns New York.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class StateLookup extends ConsoleProgram {

	private HashMap<String, String> states = new HashMap<String, String>();

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");
		
		readStateNames("States.txt");
		while (true) {
			String stateInitial = readLine("Enter state initial (e.g. NY): ");
			if (stateInitial.length() == 0)
				break;
			println(states.get(stateInitial.toUpperCase()));
		}
	}

	private void readStateNames(String fileName) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				if (line.length() != 0) {
					readStateEntry(line);
				}
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}

	private void readStateEntry(String line) {
		int comma = line.indexOf(",");
		String stateInitial = line.substring(0, comma).trim();
		String stateName = line.substring(comma + 1).trim();
		states.put(stateInitial, stateName);
	}

}
