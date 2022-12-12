import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: StockCanvas
 * 
 * Draws the graphs.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class StockCanvas extends GCanvas implements ComponentListener {

	private static final int Y_OFFSET = 15;
	private RandomGenerator rgen = new RandomGenerator();
	private ArrayList<StockEntry> entries = new ArrayList<StockEntry>();
	private List<String> dates;
	private int nrOfMonths = 12;
	private double maxPrice = 300;

	public StockCanvas(List<String> dates) {
		this.dates = dates;
		addComponentListener(this);
	}

	public void clear() {
		entries.clear();
		update();
	}

	public void addEntry(StockEntry entry) {
		entries.add(entry);
		update();
	}

	private void update() {
		removeAll();
		drawGrid();
		drawEntries();
	}

	private void drawGrid() {
		int h = getHeight() - Y_OFFSET;
		int stepX = getWidth() / (nrOfMonths);
		int nrOfSteps = 3;
		int priceStep = (int) maxPrice / nrOfSteps;
		int stepY = h / nrOfSteps;

		// horizontal
		int price = (int) maxPrice;
		int y = 0;
		for (int i = 0; i < nrOfSteps + 1; i++) {
			GLine line = new GLine(stepX, y, getWidth(), y);
			line.setColor(Color.LIGHT_GRAY);
			add(line);

			GLabel lblPrice = new GLabel("" + price);
			lblPrice.setFont("Arial-9");
			add(lblPrice, 5, y + 5);

			y += stepY;
			price -= priceStep;
		}

		// vertical
		int x = stepX;
		// for (int i = 0; i < nrOfMonths; i++) {
		for (int i = nrOfMonths - 1; i >= 0; i--) {
			GLine line = new GLine(x, 0, x, h);
			line.setColor(Color.LIGHT_GRAY);
			add(line);

			GLabel lblDate = new GLabel(dates.get(i).substring(0, 6));
			lblDate.setFont("Arial-9");
			add(lblDate, x - 15, h + 10);

			x += stepX;
		}
	}

	private void drawEntries() {
		int h = getHeight() - Y_OFFSET;
		for (StockEntry entry : entries) {
			Color colr = rgen.nextColor();

			String symbol = entry.getSymbol();
			GLabel lblSymbol = new GLabel(symbol);
			lblSymbol.setFont("Arial-bold-12");
			lblSymbol.setColor(colr);

			List<Double> prices = entry.getPrices();
			double factor = h / maxPrice;
			double p0 = h - prices.get( nrOfMonths - 1) * factor;

			int stepX = getWidth() / (nrOfMonths);
			int x = stepX;
			// for (int i = 1; i < nrOfMonths; i++) {
			for (int i = nrOfMonths - 2; i >= 0; i--) {
				double p1 = h - prices.get(i) * factor;
				System.out.println(p1);
				GLine line = new GLine(x, p0, x + stepX, p1);
				line.setColor(colr);
				add(line);
				x += stepX;
				p0 = p1;
			}
			add(lblSymbol, getWidth() - 35, p0);
		}
	}

	public void componentHidden(ComponentEvent arg0) {
	}

	public void componentMoved(ComponentEvent arg0) {
	}

	public void componentResized(ComponentEvent arg0) {
		update();
	}

	public void componentShown(ComponentEvent arg0) {
	}

}
