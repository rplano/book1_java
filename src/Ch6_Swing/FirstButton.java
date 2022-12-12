import java.awt.event.ActionEvent;

import javax.swing.JButton;

import acm.program.*;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: 2. FirstButton
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class FirstButton extends ConsoleProgram {

	public void init() {
		setSize(300, 150);
		JButton btn = new JButton("OK");
		add(btn, SOUTH);

		addActionListeners();
	}

	public void actionPerformed(ActionEvent e) {
		println("hi:" + e.getActionCommand());
	}

}
