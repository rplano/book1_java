import javax.swing.JLabel;

import java.awt.Font;
import java.util.Date;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: 1. DateAndTime
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class DateAndTime extends Program {

	public void init() {
		setSize(300, 150);
		Date dt = new Date();
		JLabel fritz = new JLabel(dt.toLocaleString());
		fritz.setFont(new Font("SansSerif", Font.PLAIN, 20));
		add(fritz, NORTH);
	}
}
