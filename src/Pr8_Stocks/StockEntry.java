import java.util.ArrayList;
import java.util.List;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: StockEntry
 * 
 * A stock entry, representing the data of one stock symbol.<br/>
 * a,45.51,42.82,45.1936,42.0624,41.6136,42.7478,...,null,
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class StockEntry {
	private String symbol;
	private List<Double> prices;

	public StockEntry(String line) {
		String[] sVals = line.split(",");
		symbol = sVals[0];
		prices = new ArrayList<Double>();
		for (int i = 1; i < sVals.length; i++) {
			if (sVals[i].equals("null")) {
				prices.add(-1.0);
			} else {
				prices.add(Double.parseDouble(sVals[i]));
			}
		}
	}

	public String getSymbol() {
		return symbol;
	}

	public List<Double> getPrices() {
		return prices;
	}

	public String toString() {
		String s = "StockEntry [symbol=" + symbol + ", prices=";
		for (int i = 0; i < 10; i++) {
			s += prices.get(i) + ",";
		}
		s += "...]";
		return s;
	}
}
