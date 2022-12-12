import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: 7. FavoriteColor
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class FavoriteColor extends ConsoleProgram {
	private JComboBox colorPicker;

	public void init() {
		setSize(300, 150);
		colorPicker = new JComboBox();
		colorPicker.addItem("Red");
		colorPicker.addItem("White");
		colorPicker.addItem("Blue");
		add(colorPicker, SOUTH);

		addActionListeners();
	}

	public void actionPerformed(ActionEvent e) {
		println("Color:" + colorPicker.getSelectedItem());
	}

}
