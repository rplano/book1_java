import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: StockDataBase
 * 
 * Containing all stock data.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class StockDataBase {
	private Map<String, StockEntry> stockDB = new HashMap<String, StockEntry>();
	private List<String> dates = new ArrayList<String>();

	public StockDataBase(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			// first line contains dates:
			String line = br.readLine();
			readDates(line);

			// other lines contain data:
			readStockPrices(br);
			
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StockEntry findEntry(String symbol) {
		return stockDB.get(symbol);
	}

	public List<String> getDates() {
		return dates;
	}

	private void readDates(String line) {
		String[] datesArray = line.split(",");
		for (int i = 1; i < datesArray.length; i++) {
			dates.add(datesArray[i]);
		}
	}

	private void readStockPrices(BufferedReader br) throws IOException {
		String line;
		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			StockEntry entry = new StockEntry(line);
			stockDB.put(entry.getSymbol(), entry);
		}
	}

}
