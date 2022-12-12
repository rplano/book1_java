import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: WorldMap
 * 
 * In the internet look for Latitude and Longitude of World Cities. Put them in
 * a data file. Draw the data.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class WorldMap extends GraphicsProgram {
	private final int SIZE = 600;
	private final int WIDTH = SIZE;
	private final int HEIGHT = SIZE / 2;
	private final int CITY_SIZE = 5;

	private static final String FILE_NAME = "Cities.txt";

	public void run() {
		setSize(WIDTH, HEIGHT);
		loadAndDisplayData(FILE_NAME);
	}

	private void loadAndDisplayData(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;

				if (!line.startsWith("#")) {
					// Germany, Berlin, 52", 32', N, 13", 25', E
					String[] data = line.split(",");
					String country = data[0].trim();
					String name = data[1].trim();
					String lat1 = data[2].trim();
					String lat2 = data[3].trim();
					String lat3 = data[4].trim();

					int lat = Integer.parseInt(lat1);
					if (lat3.endsWith("S")) {
						lat = -lat;
					}
					String lon1 = data[5].trim();
					String lon2 = data[6].trim();
					String lon3 = data[7].trim();
					int lon = Integer.parseInt(lon1);
					if (lon3.endsWith("E")) {
						lon = -lon;
					}

					double x = (0.5 - lon / 360.0) * WIDTH;
					double y = (0.5 - lat / 180.0) * HEIGHT;
					GOval city = new GOval(CITY_SIZE, CITY_SIZE);
					if (country.equals("Germany")) {
						city.setFilled(true);
						city.setColor(Color.RED);
					}
					add(city, x, y);
					// //println(name+":"+x+","+y);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
