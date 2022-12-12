import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: Trains
 * 
 * Shows the train connections between major German cities, and allows you to
 * plan a trip. Try to get from Hamburg to Frankfurt.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Trains extends ConsoleProgram {

	private HashMap<String, ArrayList<String>> connections = new HashMap<String, ArrayList<String>>();
	private ArrayList<String> cities = new ArrayList<String>();

	public void run() {
		setSize(400, 400);
		setFont("Times New Roman-bold-20");

		loadConnectionsFromFile();

		println("Available cities are:");
		printCityList(cities);

		String nextCity = getStartingCity("Where do you want to start: ");
		while (nextCity.length() > 0) {
			listDestinations(nextCity);
			nextCity = getStartingCity("Where do you want to go next: ");
		}

		println("Done.");
	}

	private void listDestinations(String city) {
		ArrayList<String> destinations = connections.get(city);
		println("From " + city + " you can go to: ");
		printCityList(destinations);
	}

	private String getStartingCity(String msg) {
		String nextCity = "";
		while (true) {
			nextCity = readLine(msg);
			if (cities.contains(nextCity) || nextCity.length() == 0)
				break;
		}
		return nextCity;
	}

	private void printCityList(ArrayList<String> cities) {
		print("  ");
		for (String city : cities) {
			print(city + ", ");
		}
		println();
	}

	private void loadConnectionsFromFile() {
		BufferedReader rd;
		try {
			rd = new BufferedReader(new FileReader("Trains.txt"));
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				addConnectionToMap(line);
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addConnectionToMap(String line) {
		if (line.trim().length() > 0) {
			StringTokenizer st = new StringTokenizer(line, ">");
			String source = st.nextToken().trim();
			String destination = st.nextToken().trim();

			if (!cities.contains(source)) {
				cities.add(source);
				connections.put(source, new ArrayList<String>());
			}
			ArrayList<String> cits = connections.get(source);
			cits.add(destination);
		}
	}
}
