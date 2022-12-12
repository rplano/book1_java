import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: Adventure
 * 
 * A console program, where you walk through a house (your house) and discover
 * things
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Adventure extends ConsoleProgram {

	private final String FILE_NAME = "Adventure.txt";

	private HashMap<String, ArrayList<String>> roomMap;

	public void run() {
		setSize(400, 400);
		setFont("Times New Roman-bold-20");
		
		loadWorld();
		// printMap();
		startAdventure("kitchen");
	}

	private void startAdventure(String currentRoom) {
		while (true) {
			println("You are currently in " + currentRoom + ".");
			println("You can go to: " + roomMap.get(currentRoom));
			currentRoom = readLine("Where do you want to go?");
			if (currentRoom.length() == 0)
				break;
		}
		println("Thank you for playing!");
	}

	private void printMap() {
		for (String room : roomMap.keySet()) {
			println(room + "->" + roomMap.get(room));
		}
	}

	private void loadWorld() {
		roomMap = new HashMap<String, ArrayList<String>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				String[] rooms = line.split(">");
				String from = rooms[0].trim();
				String to = rooms[1].trim();
				ArrayList<String> toRooms = roomMap.get(from);
				if (toRooms == null) {
					toRooms = new ArrayList<String>();
				}
				toRooms.add(to);
				roomMap.put(from, toRooms);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
