import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: Stocks
 * 
 * Draws charts of S&P500 stocks.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Stocks extends Program {

	private StockDataBase db;
	private StockCanvas canvas;
	private JTextField tfSymbol;

	public void init() {
		setSize(400, 400);
		// setFont("monospaced-18");

		buildInteractors();
		db = new StockDataBase("SP500_HistoricalStockDataMonthly.csv");
		canvas = new StockCanvas(db.getDates());
		add(canvas, CENTER);

		addActionListeners();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Graph")) {
			StockEntry entry = db.findEntry(tfSymbol.getText());
			if (entry != null) {
				canvas.addEntry(entry);
			}
		} else {
			canvas.clear();
		}
	}

	private void buildInteractors() {
		JLabel lbl = new JLabel("Symbol: ");
		add(lbl, SOUTH);

		tfSymbol = new JTextField(10);
		add(tfSymbol, SOUTH);

		JButton btnGraph = new JButton("Graph");
		add(btnGraph, SOUTH);

		JButton btnClear = new JButton("Clear");
		add(btnClear, SOUTH);
	}

	// test, nflx, ibm, ebay, msft, amd, nvda, yhoo, intc, goog, aapl, amzn
	private void testDB(String symbol) {
		StockEntry entry = db.findEntry(symbol);
		if (entry != null) {
			println(entry);
		} else {
			println("No entry found for: " + symbol);
		}
		// println(db.getDates());
	}

}
