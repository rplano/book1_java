import javax.swing.JCheckBox;
import javax.swing.JLabel;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: 5. Pizza
 * 
 * @see http://www.variationenzumthema.de/
 * @author Ralph P. Lano
 */
public class Pizza extends Program {

	public void init() {
		setSize(300, 150);

		JLabel lbl = new JLabel("Select your toppings:");
		add(lbl, NORTH);

		JCheckBox topping1 = new JCheckBox("Tomatoes");
		add(topping1, CENTER);
		JCheckBox topping2 = new JCheckBox("Bacon");
		add(topping2, CENTER);
		JCheckBox topping3 = new JCheckBox("Onions");
		add(topping3, CENTER);

	}
}
